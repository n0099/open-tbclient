package com.baidu.ar.ui.b;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.ViewGroup;
import com.baidu.ar.b;
import com.baidu.ar.logo.IttRecognitionCallback;
import com.baidu.ar.logo.IttRecognitionManager;
import com.baidu.ar.logo.LogoModel;
import com.baidu.ar.logo.RecognitionRes;
import com.baidu.ar.msghandler.ComponentMessageType;
import com.baidu.ar.msghandler.ComponentMsgHandler;
import com.baidu.ar.ui.g;
import com.baidu.ar.util.NetworkUtil;
import com.baidu.ar.util.Res;
import com.baidu.ar.util.UiUtils;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes3.dex */
public class a implements IttRecognitionCallback {
    Context a;
    private b b;
    private ExecutorService c = Executors.newSingleThreadExecutor();
    private int d = 2;
    private boolean e = false;
    private Dialog f;

    public a(Context context, ViewGroup viewGroup, b bVar) {
        Res.addResource(context);
        this.b = bVar;
        this.a = context;
        IttRecognitionManager.getInstance().initCloudRecognition(context, this);
    }

    private void a(DialogInterface.OnClickListener onClickListener) {
        if (this.f != null || this.a == null) {
            return;
        }
        this.f = g.d(this.a, new DialogInterface.OnClickListener() { // from class: com.baidu.ar.ui.b.a.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                a.this.d();
                a.this.d = 0;
            }
        }, onClickListener);
        UiUtils.showDialogSafely(this.f);
    }

    public void a() {
        this.d = 0;
    }

    public void a(final byte[] bArr, final int i, final int i2) {
        if (this.d == 0) {
            this.d = 1;
            if (NetworkUtil.isNetworkConnected(this.a)) {
                this.c.execute(new Runnable() { // from class: com.baidu.ar.ui.b.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        IttRecognitionManager.getInstance().setYUVFile(bArr, i, i2);
                    }
                });
            } else {
                a(new DialogInterface.OnClickListener() { // from class: com.baidu.ar.ui.b.a.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i3) {
                        a.this.b.h().getActivity().finish();
                    }
                });
            }
        }
    }

    public void b() {
        this.d = 2;
    }

    public void c() {
        if (this.d == 2) {
            return;
        }
        this.d = 0;
    }

    public void d() {
        if (this.f != null) {
            this.f.dismiss();
            this.f = null;
        }
    }

    public void e() {
        if (this.d == 2) {
            return;
        }
        this.d = 1;
    }

    public void f() {
        this.d = 2;
        b();
        d();
        IttRecognitionManager.getInstance().releaseInstance();
    }

    @Override // com.baidu.ar.logo.IttRecognitionCallback
    public void recognition(List<RecognitionRes> list) {
        if (this.d == 2) {
            return;
        }
        if (list.size() <= 0) {
            this.d = 0;
            return;
        }
        LogoModel matchLogoKey = IttRecognitionManager.getInstance().matchLogoKey(list);
        if (matchLogoKey == null) {
            this.d = 0;
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("id", Integer.valueOf((int) ComponentMessageType.MSG_TYPE_LOGOT));
        hashMap.put("logo_code", Integer.valueOf((int) ComponentMessageType.MSG_TYPE_LOGO_HIT));
        hashMap.put("logo_result", matchLogoKey.getHeadName());
        ComponentMsgHandler.sendMessageToLua(hashMap);
        this.d = 2;
    }
}

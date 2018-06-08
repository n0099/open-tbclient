package com.baidu.ar.msghandler;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;
import com.baidu.ar.bean.DialogBean;
import com.baidu.ar.bean.ToastBean;
import com.baidu.baiduarsdk.ArBridge;
import com.baidu.baiduarsdk.util.MsgParamsUtil;
import com.baidu.fsg.base.armor.RimArmor;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class b implements d {
    private Context a;
    private Handler b = new Handler(Looper.getMainLooper()) { // from class: com.baidu.ar.msghandler.b.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Bundle data;
            if (message == null || !(message.obj instanceof Context) || (data = message.getData()) == null) {
                return;
            }
            switch (message.what) {
                case 1:
                    b.this.a((Context) message.obj, (DialogBean) data.get("bean"));
                    return;
                case 2:
                    b.this.a((Context) message.obj, (ToastBean) data.get("bean"));
                    return;
                default:
                    return;
            }
        }
    };

    public b(Context context) {
        this.a = context;
    }

    private void a(HashMap<String, Object> hashMap) {
        if (hashMap == null) {
            return;
        }
        DialogBean dialogBean = new DialogBean();
        if (hashMap.get("msg") != null) {
            dialogBean.a(MsgParamsUtil.obj2String(hashMap.get("msg"), null));
        }
        if (hashMap.get("title") != null) {
            dialogBean.b(MsgParamsUtil.obj2String(hashMap.get("title"), null));
        }
        if (hashMap.get("confirm_text") != null) {
            dialogBean.c(MsgParamsUtil.obj2String(hashMap.get("confirm_text"), null));
        }
        if (hashMap.get(WriteImageActivityConfig.CANCEL_TEXT) != null) {
            dialogBean.d(MsgParamsUtil.obj2String(hashMap.get(WriteImageActivityConfig.CANCEL_TEXT), null));
        }
        if (hashMap.get(RimArmor.KEY) != null) {
            dialogBean.e(MsgParamsUtil.obj2String(hashMap.get(RimArmor.KEY), null));
        }
        a(this.a, dialogBean);
    }

    private void b(HashMap<String, Object> hashMap) {
        if (hashMap == null) {
            return;
        }
        ToastBean toastBean = new ToastBean();
        if (hashMap.get("msg") != null) {
            toastBean.a(MsgParamsUtil.obj2String(hashMap.get("msg"), null));
        }
        if (hashMap.get(RimArmor.KEY) != null) {
            toastBean.b(MsgParamsUtil.obj2String(hashMap.get(RimArmor.KEY), null));
        }
        a(this.a, toastBean);
    }

    protected void a(Context context, final DialogBean dialogBean) {
        if (dialogBean == null || context == null) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(dialogBean.b());
        builder.setMessage(dialogBean.a());
        builder.setPositiveButton(dialogBean.c(), new DialogInterface.OnClickListener() { // from class: com.baidu.ar.msghandler.b.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("id", Integer.valueOf((int) ComponentMessageType.MSG_TYPE_DIALOG_RESULT));
                hashMap.put("result", "confirm");
                hashMap.put(RimArmor.KEY, dialogBean.e());
                ArBridge.getInstance().sendMessage(ArBridge.MessageType.MSG_TYPE_SDK_LUA_BRIDGE, hashMap);
            }
        });
        builder.setNegativeButton(dialogBean.d(), new DialogInterface.OnClickListener() { // from class: com.baidu.ar.msghandler.b.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("id", Integer.valueOf((int) ComponentMessageType.MSG_TYPE_DIALOG_RESULT));
                hashMap.put("result", "cancel");
                hashMap.put(RimArmor.KEY, dialogBean.e());
                ArBridge.getInstance().sendMessage(ArBridge.MessageType.MSG_TYPE_SDK_LUA_BRIDGE, hashMap);
            }
        });
        AlertDialog create = builder.create();
        create.setCanceledOnTouchOutside(false);
        try {
            create.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void a(Context context, ToastBean toastBean) {
        if (toastBean == null || context == null) {
            return;
        }
        try {
            Toast makeText = Toast.makeText(context, toastBean.a(), 0);
            makeText.setGravity(17, 0, 0);
            makeText.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.ar.msghandler.d
    public void parseComponentData(HashMap<String, Object> hashMap) {
        if (hashMap == null) {
            return;
        }
        switch (MsgParamsUtil.obj2Int(hashMap.get("id"), 0)) {
            case ComponentMessageType.MSG_TYPE_SHOW_DIALOG /* 21111 */:
                a(hashMap);
                return;
            case ComponentMessageType.MSG_TYPE_DIALOG_RESULT /* 21112 */:
            default:
                return;
            case ComponentMessageType.MSG_TYPE_SHOW_TOAST /* 21113 */:
                b(hashMap);
                return;
        }
    }

    @Override // com.baidu.ar.msghandler.d
    public void release() {
        this.a = null;
        this.b.removeCallbacksAndMessages(null);
    }
}

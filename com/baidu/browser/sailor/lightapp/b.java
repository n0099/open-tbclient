package com.baidu.browser.sailor.lightapp;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.SparseArray;
import android.webkit.MimeTypeMap;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import java.io.File;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class b implements Runnable {
    final /* synthetic */ boolean IJ;
    final /* synthetic */ BdLightappKernelJsCallback IK;
    final /* synthetic */ int IL;
    final /* synthetic */ BdLightappKernelClient IP;
    final /* synthetic */ String val$path;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BdLightappKernelClient bdLightappKernelClient, boolean z, String str, BdLightappKernelJsCallback bdLightappKernelJsCallback, int i) {
        this.IP = bdLightappKernelClient;
        this.IJ = z;
        this.val$path = str;
        this.IK = bdLightappKernelJsCallback;
        this.IL = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x010d  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        SparseArray sparseArray;
        NumberFormatException numberFormatException;
        int i;
        int i2;
        int i3;
        int i4;
        String str;
        int i5;
        File file;
        String mimeTypeFromExtension;
        SparseArray sparseArray2;
        SparseArray sparseArray3;
        int i6 = 100;
        int i7 = 0;
        if (!this.IJ || TextUtils.isEmpty(this.val$path)) {
            this.IK.setResult(3);
        } else {
            File file2 = new File(this.val$path);
            HashMap<String, String> configsMap = this.IK.getConfigsMap();
            try {
                i3 = Integer.parseInt(configsMap.get("width"));
                try {
                    i4 = Integer.parseInt(configsMap.get("height"));
                } catch (NumberFormatException e) {
                    i = i3;
                    numberFormatException = e;
                    i2 = 0;
                }
            } catch (NumberFormatException e2) {
                numberFormatException = e2;
                i = 0;
                i2 = 0;
            }
            try {
                int parseInt = Integer.parseInt(configsMap.get("quality"));
                if (parseInt <= 0 || parseInt > 100) {
                    parseInt = 100;
                }
                i6 = parseInt;
            } catch (NumberFormatException e3) {
                i2 = i4;
                i = i3;
                numberFormatException = e3;
                numberFormatException.printStackTrace();
                i3 = i;
                i4 = i2;
                String str2 = null;
                String str3 = this.val$path;
                String str4 = configsMap.get("mediaType");
                if (i3 > 0) {
                }
                str = str3;
                i5 = 0;
                file = file2;
                this.IK.addField("fullPath", str);
                int lastIndexOf = this.val$path.lastIndexOf(".");
                mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(lastIndexOf > 0 ? this.val$path.substring(lastIndexOf + 1) : "");
                BdLightappKernelJsCallback bdLightappKernelJsCallback = this.IK;
                if (TextUtils.isEmpty(mimeTypeFromExtension)) {
                }
                bdLightappKernelJsCallback.addField("type", mimeTypeFromExtension);
                this.IK.addField("name", file.getName());
                this.IK.addField("lastModified", Long.toString(file.lastModified()));
                this.IK.addField(TiebaInitialize.LogFields.SIZE, Long.toString(file.length()));
                this.IK.addField("height", String.valueOf(i5));
                this.IK.addField("width", String.valueOf(i7));
                this.IK.addField("base64", str2);
                this.IK.notifyResult();
                sparseArray = this.IP.mJsCallbacks;
                sparseArray.remove(this.IL);
            }
            String str22 = null;
            String str32 = this.val$path;
            String str42 = configsMap.get("mediaType");
            if (i3 > 0 || i4 <= 0 || !TextUtils.equals(str42, "lightapp.device.MEDIA_TYPE.IMAGE")) {
                str = str32;
                i5 = 0;
                file = file2;
            } else {
                Bitmap a = com.baidu.browser.sailor.util.d.a(this.val$path, Math.min(i3, i4));
                if (a == null) {
                    this.IK.sendCallBackWithRetCode(105);
                    sparseArray3 = this.IP.mJsCallbacks;
                    sparseArray3.remove(this.IL);
                    return;
                }
                i7 = a.getWidth();
                int height = a.getHeight();
                String b = TextUtils.equals(configsMap.get("base64"), "true") ? com.baidu.browser.sailor.util.d.b(a, i6) : null;
                String a2 = com.baidu.browser.sailor.util.b.a(this.IP.getPaivateDir(), file2.getName());
                boolean a3 = com.baidu.browser.sailor.util.d.a(a, a2, i6);
                a.recycle();
                if (!a3) {
                    this.IK.sendCallBackWithRetCode(106);
                    sparseArray2 = this.IP.mJsCallbacks;
                    sparseArray2.remove(this.IL);
                    return;
                }
                str22 = b;
                str = a2;
                file = new File(a2);
                i5 = height;
            }
            this.IK.addField("fullPath", str);
            int lastIndexOf2 = this.val$path.lastIndexOf(".");
            mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(lastIndexOf2 > 0 ? this.val$path.substring(lastIndexOf2 + 1) : "");
            BdLightappKernelJsCallback bdLightappKernelJsCallback2 = this.IK;
            if (TextUtils.isEmpty(mimeTypeFromExtension)) {
                mimeTypeFromExtension = "";
            }
            bdLightappKernelJsCallback2.addField("type", mimeTypeFromExtension);
            this.IK.addField("name", file.getName());
            this.IK.addField("lastModified", Long.toString(file.lastModified()));
            this.IK.addField(TiebaInitialize.LogFields.SIZE, Long.toString(file.length()));
            this.IK.addField("height", String.valueOf(i5));
            this.IK.addField("width", String.valueOf(i7));
            this.IK.addField("base64", str22);
        }
        this.IK.notifyResult();
        sparseArray = this.IP.mJsCallbacks;
        sparseArray.remove(this.IL);
    }
}

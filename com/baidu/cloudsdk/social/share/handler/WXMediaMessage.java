package com.baidu.cloudsdk.social.share.handler;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.baidu.cloudsdk.common.util.Validator;
import com.tencent.mm.sdk.openapi.WXMediaMessage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
/* loaded from: classes.dex */
public final class WXMediaMessage {

    /* renamed from: a  reason: collision with root package name */
    private String f875a;
    private String b;
    private byte[] c;
    private IMediaObject d;

    /* loaded from: classes.dex */
    public interface IMediaObject {
        public static final int TYPE_UNKNOWN = 0;
        public static final int TYPE_URL = 5;

        String identifier();

        void serialize(Bundle bundle);

        int type();
    }

    /* loaded from: classes.dex */
    public class WXWebpageObject implements IMediaObject {

        /* renamed from: a  reason: collision with root package name */
        private String f876a;

        public WXWebpageObject(String str) {
            this.f876a = str;
        }

        @Override // com.baidu.cloudsdk.social.share.handler.WXMediaMessage.IMediaObject
        public String identifier() {
            return "com.tencent.mm.sdk.openapi.WXWebpageObject";
        }

        @Override // com.baidu.cloudsdk.social.share.handler.WXMediaMessage.IMediaObject
        public void serialize(Bundle bundle) {
            Validator.notNull(bundle, "bundle");
            bundle.putString("_wxwebpageobject_webpageUrl", this.f876a);
        }

        @Override // com.baidu.cloudsdk.social.share.handler.WXMediaMessage.IMediaObject
        public int type() {
            return 5;
        }
    }

    public WXMediaMessage(String str, String str2, IMediaObject iMediaObject) {
        this.f875a = str;
        this.b = str2;
        this.d = iMediaObject;
    }

    public static byte[] b(Bitmap bitmap) {
        if (bitmap != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            r0 = bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream) ? byteArrayOutputStream.toByteArray() : null;
            try {
                byteArrayOutputStream.close();
            } catch (IOException e) {
            }
        }
        return r0;
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putInt("_wxobject_sdkVer", 553844737);
        bundle.putString("_wxobject_title", this.f875a);
        bundle.putString("_wxobject_description", this.b);
        bundle.putByteArray("_wxobject_thumbdata", this.c);
        if (this.d != null) {
            bundle.putString(WXMediaMessage.Builder.KEY_IDENTIFIER, this.d.identifier());
            this.d.serialize(bundle);
        }
        return bundle;
    }

    public WXMediaMessage a(Bitmap bitmap) {
        this.c = b(bitmap);
        return this;
    }
}

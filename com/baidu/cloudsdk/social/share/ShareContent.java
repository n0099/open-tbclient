package com.baidu.cloudsdk.social.share;

import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.ay;
import com.baidu.cloudsdk.common.util.Utils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public final class ShareContent implements Parcelable {
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private Uri g;
    private WeakReference h;
    private boolean i;
    private Location j;
    private int k;
    private byte[] l;
    private String m;
    private int n;
    private int o;
    private int p;
    private int q;
    private static final String a = Environment.getExternalStorageDirectory().getPath() + "/baidu/.tmp/";
    public static final Parcelable.Creator CREATOR = new ay();

    public ShareContent() {
        this.i = true;
        this.k = 5;
        this.n = 100;
        this.o = 1;
        this.p = 0;
        this.q = 0;
    }

    public ShareContent(String str, String str2) {
        this.i = true;
        this.k = 5;
        this.n = 100;
        this.o = 1;
        this.p = 0;
        this.q = 0;
        this.b = str;
        this.c = str2;
    }

    public ShareContent(String str, String str2, String str3) {
        this(str, str2);
        this.f = str3;
    }

    public ShareContent(String str, String str2, String str3, Uri uri) {
        this(str, str2, str3);
        this.g = uri;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCompressDataQuality() {
        return this.n;
    }

    public byte[] getCompressedImageData() {
        Bitmap bitmap;
        if (this.h == null || (bitmap = (Bitmap) this.h.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] byteArray = bitmap.compress(Bitmap.CompressFormat.PNG, this.n, byteArrayOutputStream) ? byteArrayOutputStream.toByteArray() : null;
        try {
            byteArrayOutputStream.close();
            return byteArray;
        } catch (IOException e) {
            return byteArray;
        }
    }

    public String getContent() {
        return this.c;
    }

    public String getEmailBody() {
        String str = this.e;
        if (Build.VERSION.SDK_INT >= 16) {
            str = this.d;
        }
        return TextUtils.isEmpty(str) ? getContent() + "\r\n" + getLinkUrl() : str;
    }

    public Bitmap getImageData() {
        Bitmap bitmap;
        if (this.h == null || (bitmap = (Bitmap) this.h.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public Uri getImageUri() {
        return this.g;
    }

    public String getLinkUrl() {
        return this.f;
    }

    public Location getLocation() {
        return this.j;
    }

    public int getQQFlagType() {
        return this.p;
    }

    public int getQQRequestType() {
        return this.o;
    }

    public int getQZoneRequestType() {
        return this.q;
    }

    public String getTitle() {
        return this.b;
    }

    public byte[] getWXMediaContent() {
        return this.l;
    }

    public String getWXMediaContentPath() {
        return this.m;
    }

    public int getWXMediaObjectType() {
        return this.k;
    }

    public void saveImageDataIfNecessary() {
        byte[] compressedImageData;
        if (this.h == null || this.i || (compressedImageData = getCompressedImageData()) == null) {
            return;
        }
        File file = new File(a + Utils.md5("screenshot") + ".png");
        if (file.exists()) {
            file.delete();
        }
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(compressedImageData);
            fileOutputStream.close();
            this.g = Uri.fromFile(file);
            this.i = true;
        } catch (Exception e) {
        }
    }

    public ShareContent setCompressDataQuality(int i) {
        this.n = i;
        return this;
    }

    public ShareContent setContent(String str) {
        this.c = str;
        return this;
    }

    public ShareContent setEmailBody(String str, String str2) {
        this.d = str;
        this.e = str2;
        return this;
    }

    public ShareContent setImageData(Bitmap bitmap) {
        this.h = new WeakReference(bitmap);
        this.i = false;
        return this;
    }

    public ShareContent setImageUri(Uri uri) {
        this.g = uri;
        return this;
    }

    public ShareContent setLinkUrl(String str) {
        this.f = str;
        return this;
    }

    public ShareContent setLocation(Location location) {
        this.j = location;
        return this;
    }

    public void setQQFlagType(int i) {
        this.p = i;
    }

    public void setQQRequestType(int i) {
        this.o = i;
    }

    public void setQZoneRequestType(int i) {
        this.q = i;
    }

    public ShareContent setTitle(String str) {
        this.b = str;
        return this;
    }

    public void setWXMediaContent(byte[] bArr) {
        this.l = bArr;
    }

    public void setWXMediaContentPath(String str) {
        this.m = str;
    }

    public void setWXMediaObjectType(int i) {
        this.k = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        saveImageDataIfNecessary();
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.f);
        parcel.writeString(this.e);
        parcel.writeString(this.d);
        parcel.writeInt(this.k);
        parcel.writeParcelable(this.g, i);
        parcel.writeParcelable(this.j, i);
        parcel.writeInt(this.n);
        parcel.writeString(this.m);
        parcel.writeInt(this.p);
        parcel.writeInt(this.o);
        parcel.writeInt(this.q);
        if (this.l == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(this.l.length);
        parcel.writeByteArray(this.l);
    }
}

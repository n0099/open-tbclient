package com.baidu.cloudsdk.social.share;

import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.cloudsdk.common.util.Utils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes.dex */
public final class ShareContent implements Parcelable {
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private Uri g;
    private Bitmap h;
    private boolean i;
    private Location j;

    /* renamed from: a  reason: collision with root package name */
    private static final String f862a = Environment.getExternalStorageDirectory().getPath() + "/baidu/.tmp/";
    public static final Parcelable.Creator CREATOR = new ab();

    public ShareContent() {
        this.i = true;
    }

    public ShareContent(String str, String str2) {
        this.i = true;
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

    public byte[] getCompressedImageData() {
        if (this.h != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            r0 = this.h.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream) ? byteArrayOutputStream.toByteArray() : null;
            try {
                byteArrayOutputStream.close();
            } catch (IOException e) {
            }
        }
        return r0;
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
        return this.h;
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

    public String getTitle() {
        return this.b;
    }

    public void saveImageDataIfNecessary() {
        byte[] compressedImageData;
        if (this.h == null || this.i || (compressedImageData = getCompressedImageData()) == null) {
            return;
        }
        File file = new File(f862a + Utils.md5(compressedImageData) + ".png");
        if (file.exists()) {
            this.g = Uri.fromFile(file);
            this.i = true;
            return;
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
        this.h = bitmap;
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

    public ShareContent setTitle(String str) {
        this.b = str;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        saveImageDataIfNecessary();
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.f);
        parcel.writeString(this.e);
        parcel.writeString(this.d);
        parcel.writeParcelable(this.g, i);
        parcel.writeParcelable(this.j, i);
    }
}

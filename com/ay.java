package com;

import android.location.Location;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.cloudsdk.social.share.ShareContent;
/* loaded from: classes.dex */
public final class ay implements Parcelable.Creator {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: j */
    public ShareContent createFromParcel(Parcel parcel) {
        String readString = parcel.readString();
        String readString2 = parcel.readString();
        String readString3 = parcel.readString();
        String readString4 = parcel.readString();
        String readString5 = parcel.readString();
        int readInt = parcel.readInt();
        Uri uri = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        Location location = (Location) parcel.readParcelable(Location.class.getClassLoader());
        int readInt2 = parcel.readInt();
        String readString6 = parcel.readString();
        int readInt3 = parcel.readInt();
        int readInt4 = parcel.readInt();
        int readInt5 = parcel.readInt();
        int readInt6 = parcel.readInt();
        byte[] bArr = null;
        if (readInt6 != 0) {
            bArr = new byte[readInt6];
            parcel.readByteArray(bArr);
        }
        ShareContent shareContent = new ShareContent(readString, readString2, readString3, uri);
        shareContent.setEmailBody(readString5, readString4);
        shareContent.setLocation(location);
        shareContent.setCompressDataQuality(readInt2);
        shareContent.setWXMediaContentPath(readString6);
        shareContent.setWXMediaObjectType(readInt);
        shareContent.setQQFlagType(readInt3);
        shareContent.setQQRequestType(readInt4);
        shareContent.setQZoneRequestType(readInt5);
        if (bArr != null) {
            shareContent.setWXMediaContent(bArr);
        }
        return shareContent;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: tm */
    public ShareContent[] newArray(int i) {
        return new ShareContent[i];
    }
}

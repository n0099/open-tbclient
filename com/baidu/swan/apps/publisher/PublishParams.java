package com.baidu.swan.apps.publisher;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.sapi2.activity.BaseActivity;
import d.a.m0.a.a2.e;
import d.a.m0.a.f1.e.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0010 \n\u0002\b\r\u0018\u0000 @2\u00020\u0001:\u0001@B\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b=\u0010>B¯\u0001\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010;\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010.\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010,\u001a\u00020\u0002\u0012\u0006\u0010*\u001a\u00020\u0002\u0012\b\u00100\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u00102\u001a\u00020\u0002\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u0012\b\u00109\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010(\u001a\u00020\u0002\u0012\u0006\u0010$\u001a\u00020#\u0012\u000e\u00105\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u000104\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b=\u0010?J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\u0007J\u000f\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\u0007J\u000f\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\n\u0010\u0007J\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u001b\u0010\u0015R\u0019\u0010\u001c\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u0013\u001a\u0004\b \u0010\u0015R\u001b\u0010!\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\u0013\u001a\u0004\b\"\u0010\u0015R\u0019\u0010$\u001a\u00020#8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0019\u0010(\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010\u001d\u001a\u0004\b)\u0010\u0004R\u0019\u0010*\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010\u001d\u001a\u0004\b+\u0010\u0004R\u0019\u0010,\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010\u001d\u001a\u0004\b-\u0010\u0004R\u001b\u0010.\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010\u0013\u001a\u0004\b/\u0010\u0015R\u001b\u00100\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b0\u0010\u0013\u001a\u0004\b1\u0010\u0015R\u0019\u00102\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b2\u0010\u001d\u001a\u0004\b3\u0010\u0004R!\u00105\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u0001048\u0006@\u0006¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u001b\u00109\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b9\u0010\u0013\u001a\u0004\b:\u0010\u0015R\u001b\u0010;\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010\u0013\u001a\u0004\b<\u0010\u0015¨\u0006A"}, d2 = {"Lcom/baidu/swan/apps/publisher/PublishParams;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "supportEmoji", "()Ljava/lang/Boolean;", "supportImage", "supportTarget", "supportTitle", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, "Ljava/lang/String;", "getAppId", "()Ljava/lang/String;", "appVersion", "getAppVersion", "callback", "getCallback", "cancelText", "getCancelText", "cancelTextColor", "I", "getCancelTextColor", "contentHint", "getContentHint", "emojiPath", "getEmojiPath", "", "imageRatio", "F", "getImageRatio", "()F", "maxImageNum", "getMaxImageNum", "navBarBgColor", "getNavBarBgColor", "navBarTextColor", "getNavBarTextColor", "navBarTitle", "getNavBarTitle", "publishText", "getPublishText", "publishTextColor", "getPublishTextColor", "", "showList", "Ljava/util/List;", "getShowList", "()Ljava/util/List;", "target", "getTarget", "titleHint", "getTitleHint", "<init>", "(Landroid/os/Parcel;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IFLjava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "CREATOR", "core_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class PublishParams implements Parcelable {
    public static final a CREATOR = new a(null);
    public final String appId;
    public final String appVersion;
    public final String callback;
    public final String cancelText;
    public final int cancelTextColor;
    public final String contentHint;
    public final String emojiPath;
    public final float imageRatio;
    public final int maxImageNum;
    public final int navBarBgColor;
    public final int navBarTextColor;
    public final String navBarTitle;
    public final String publishText;
    public final int publishTextColor;
    public final List<String> showList;
    public final String target;
    public final String titleHint;

    /* loaded from: classes3.dex */
    public static final class a implements Parcelable.Creator<PublishParams> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public PublishParams createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PublishParams(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public PublishParams[] newArray(int i2) {
            return new PublishParams[i2];
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public PublishParams(String str, String str2, String str3, int i2, int i3, String str4, int i4, String str5, int i5, String str6, String str7, String str8, int i6, float f2, List<String> list, String str9, String str10) {
        this.contentHint = str;
        this.titleHint = str2;
        this.navBarTitle = str3;
        this.navBarTextColor = i2;
        this.navBarBgColor = i3;
        this.publishText = str4;
        this.publishTextColor = i4;
        this.cancelText = str5;
        this.cancelTextColor = i5;
        this.target = str6;
        this.emojiPath = str7;
        this.callback = str8;
        this.maxImageNum = i6;
        this.imageRatio = f2;
        this.showList = list;
        this.appId = str9;
        this.appVersion = str10;
    }

    public final String a() {
        return this.appId;
    }

    public final String b() {
        return this.appVersion;
    }

    public final String c() {
        return this.cancelText;
    }

    public final int d() {
        return this.cancelTextColor;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String e() {
        return this.contentHint;
    }

    public final String f() {
        return this.emojiPath;
    }

    public final float g() {
        return this.imageRatio;
    }

    public final int h() {
        return this.maxImageNum;
    }

    public final int i() {
        return this.navBarBgColor;
    }

    public final int j() {
        return this.navBarTextColor;
    }

    public final String k() {
        return this.navBarTitle;
    }

    public final String l() {
        return this.publishText;
    }

    public final int m() {
        return this.publishTextColor;
    }

    public final String n() {
        return this.target;
    }

    public final String o() {
        return this.titleHint;
    }

    public final Boolean p() {
        List<String> list = this.showList;
        if (list != null) {
            return Boolean.valueOf(list.contains(ReplyEditorParams.MODULE_EMOJI));
        }
        return null;
    }

    public final Boolean q() {
        List<String> list = this.showList;
        if (list != null) {
            return Boolean.valueOf(list.contains("image"));
        }
        return null;
    }

    public final Boolean r() {
        List<String> list = this.showList;
        if (list != null) {
            return Boolean.valueOf(list.contains("target"));
        }
        return null;
    }

    public final Boolean s() {
        List<String> list = this.showList;
        if (list != null) {
            return Boolean.valueOf(list.contains("title"));
        }
        return null;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.contentHint);
        parcel.writeString(this.titleHint);
        parcel.writeString(this.navBarTitle);
        parcel.writeInt(this.navBarTextColor);
        parcel.writeInt(this.navBarBgColor);
        parcel.writeString(this.publishText);
        parcel.writeInt(this.publishTextColor);
        parcel.writeString(this.cancelText);
        parcel.writeInt(this.cancelTextColor);
        parcel.writeString(this.target);
        parcel.writeString(this.emojiPath);
        parcel.writeString(this.callback);
        parcel.writeInt(this.maxImageNum);
        parcel.writeFloat(this.imageRatio);
        parcel.writeStringList(this.showList);
        parcel.writeString(this.appId);
        parcel.writeString(this.appVersion);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ PublishParams(String str, String str2, String str3, int i2, int i3, String str4, int i4, String str5, int i5, String str6, String str7, String str8, int i6, float f2, List list, String str9, String str10, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, i2, i3, str4, i4, str5, i5, str6, str7, str8, i6, f2, list, r18, r19);
        String str11;
        String str12;
        b.a N;
        b.a N2;
        if ((i7 & 32768) != 0) {
            e i8 = e.i();
            str11 = (i8 == null || (N2 = i8.N()) == null) ? null : N2.H();
        } else {
            str11 = str9;
        }
        if ((i7 & 65536) != 0) {
            e i9 = e.i();
            str12 = (i9 == null || (N = i9.N()) == null) ? null : N.u1();
        } else {
            str12 = str10;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PublishParams(Parcel parcel) {
        this(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readFloat(), parcel.createStringArrayList(), parcel.readString(), parcel.readString());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
    }
}

package com.baidu.swan.apps.publisher;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.tieba.ss2;
import com.baidu.tieba.v73;
import com.baidu.webkit.sdk.WebChromeClient;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0010 \n\u0002\b\r\u0018\u0000 @2\u00020\u0001:\u0001@B\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b=\u0010>B¯\u0001\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010;\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010.\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010,\u001a\u00020\u0002\u0012\u0006\u0010*\u001a\u00020\u0002\u0012\b\u00100\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u00102\u001a\u00020\u0002\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u0012\b\u00109\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010(\u001a\u00020\u0002\u0012\u0006\u0010$\u001a\u00020#\u0012\u000e\u00105\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u000104\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b=\u0010?J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\u0007J\u000f\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\u0007J\u000f\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\n\u0010\u0007J\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u001b\u0010\u0015R\u0019\u0010\u001c\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u0013\u001a\u0004\b \u0010\u0015R\u001b\u0010!\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\u0013\u001a\u0004\b\"\u0010\u0015R\u0019\u0010$\u001a\u00020#8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0019\u0010(\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010\u001d\u001a\u0004\b)\u0010\u0004R\u0019\u0010*\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010\u001d\u001a\u0004\b+\u0010\u0004R\u0019\u0010,\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010\u001d\u001a\u0004\b-\u0010\u0004R\u001b\u0010.\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010\u0013\u001a\u0004\b/\u0010\u0015R\u001b\u00100\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b0\u0010\u0013\u001a\u0004\b1\u0010\u0015R\u0019\u00102\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b2\u0010\u001d\u001a\u0004\b3\u0010\u0004R!\u00105\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u0001048\u0006@\u0006¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u001b\u00109\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b9\u0010\u0013\u001a\u0004\b:\u0010\u0015R\u001b\u0010;\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010\u0013\u001a\u0004\b<\u0010\u0015¨\u0006A"}, d2 = {"Lcom/baidu/swan/apps/publisher/PublishParams;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "supportEmoji", "()Ljava/lang/Boolean;", "supportImage", "supportTarget", "supportTitle", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, "Ljava/lang/String;", "getAppId", "()Ljava/lang/String;", "appVersion", "getAppVersion", WebChromeClient.KEY_ARG_CALLBACK, "getCallback", "cancelText", "getCancelText", "cancelTextColor", "I", "getCancelTextColor", "contentHint", "getContentHint", "emojiPath", "getEmojiPath", "", "imageRatio", "F", "getImageRatio", "()F", "maxImageNum", "getMaxImageNum", "navBarBgColor", "getNavBarBgColor", "navBarTextColor", "getNavBarTextColor", "navBarTitle", "getNavBarTitle", "publishText", "getPublishText", "publishTextColor", "getPublishTextColor", "", "showList", "Ljava/util/List;", "getShowList", "()Ljava/util/List;", "target", "getTarget", "titleHint", "getTitleHint", "<init>", "(Landroid/os/Parcel;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IFLjava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "CREATOR", "core_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
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

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* loaded from: classes3.dex */
    public static final class a implements Parcelable.Creator<PublishParams> {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
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
        public PublishParams[] newArray(int i) {
            return new PublishParams[i];
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PublishParams(Parcel parcel) {
        this(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readFloat(), parcel.createStringArrayList(), parcel.readString(), parcel.readString());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
    }

    public PublishParams(String str, String str2, String str3, int i, int i2, String str4, int i3, String str5, int i4, String str6, String str7, String str8, int i5, float f, List<String> list, String str9, String str10) {
        this.contentHint = str;
        this.titleHint = str2;
        this.navBarTitle = str3;
        this.navBarTextColor = i;
        this.navBarBgColor = i2;
        this.publishText = str4;
        this.publishTextColor = i3;
        this.cancelText = str5;
        this.cancelTextColor = i4;
        this.target = str6;
        this.emojiPath = str7;
        this.callback = str8;
        this.maxImageNum = i5;
        this.imageRatio = f;
        this.showList = list;
        this.appId = str9;
        this.appVersion = str10;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ PublishParams(String str, String str2, String str3, int i, int i2, String str4, int i3, String str5, int i4, String str6, String str7, String str8, int i5, float f, List list, String str9, String str10, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, i, i2, str4, i3, str5, i4, str6, str7, str8, i5, f, list, r18, r19);
        String str11;
        String str12;
        String str13;
        ss2.a Y;
        String str14;
        ss2.a Y2;
        if ((i6 & 32768) != 0) {
            v73 M = v73.M();
            if (M != null && (Y2 = M.Y()) != null) {
                str14 = Y2.H();
            } else {
                str14 = null;
            }
            str11 = str14;
        } else {
            str11 = str9;
        }
        if ((i6 & 65536) != 0) {
            v73 M2 = v73.M();
            if (M2 != null && (Y = M2.Y()) != null) {
                str13 = Y.v1();
            } else {
                str13 = null;
            }
            str12 = str13;
        } else {
            str12 = str10;
        }
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getAppVersion() {
        return this.appVersion;
    }

    public final String getCallback() {
        return this.callback;
    }

    public final String getCancelText() {
        return this.cancelText;
    }

    public final int getCancelTextColor() {
        return this.cancelTextColor;
    }

    public final String getContentHint() {
        return this.contentHint;
    }

    public final String getEmojiPath() {
        return this.emojiPath;
    }

    public final float getImageRatio() {
        return this.imageRatio;
    }

    public final int getMaxImageNum() {
        return this.maxImageNum;
    }

    public final int getNavBarBgColor() {
        return this.navBarBgColor;
    }

    public final int getNavBarTextColor() {
        return this.navBarTextColor;
    }

    public final String getNavBarTitle() {
        return this.navBarTitle;
    }

    public final String getPublishText() {
        return this.publishText;
    }

    public final int getPublishTextColor() {
        return this.publishTextColor;
    }

    public final List<String> getShowList() {
        return this.showList;
    }

    public final String getTarget() {
        return this.target;
    }

    public final String getTitleHint() {
        return this.titleHint;
    }

    public final Boolean supportEmoji() {
        List<String> list = this.showList;
        if (list != null) {
            return Boolean.valueOf(list.contains("emoji"));
        }
        return null;
    }

    public final Boolean supportImage() {
        List<String> list = this.showList;
        if (list != null) {
            return Boolean.valueOf(list.contains("image"));
        }
        return null;
    }

    public final Boolean supportTarget() {
        List<String> list = this.showList;
        if (list != null) {
            return Boolean.valueOf(list.contains("target"));
        }
        return null;
    }

    public final Boolean supportTitle() {
        List<String> list = this.showList;
        if (list != null) {
            return Boolean.valueOf(list.contains("title"));
        }
        return null;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
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
}

package com.baidu.live.adp.lib.guide;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class Configuration implements Parcelable {
    public static Parcelable.Creator<Configuration> CREATOR = new Parcelable.Creator<Configuration>() { // from class: com.baidu.live.adp.lib.guide.Configuration.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Configuration createFromParcel(Parcel parcel) {
            Configuration configuration = new Configuration();
            configuration.mAlpha = parcel.readInt();
            configuration.mFullingViewId = parcel.readInt();
            configuration.mTargetViewId = parcel.readInt();
            configuration.mFullingColorId = parcel.readInt();
            configuration.mAutoDismiss = parcel.readByte() == 1;
            configuration.mOverlayTarget = parcel.readByte() == 1;
            return configuration;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Configuration[] newArray(int i) {
            return new Configuration[i];
        }
    };
    boolean mOutsideTouchable;
    View mTargetView = null;
    int mAlpha = 255;
    int mFullingViewId = -1;
    int mTargetViewId = -1;
    int mFullingColorId = 17170444;
    boolean mAutoDismiss = true;
    boolean mOverlayTarget = false;
    boolean mShowCloseButton = false;
    int mEnterAnimationId = -1;
    int mExitAnimationId = -1;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mAlpha);
        parcel.writeInt(this.mFullingViewId);
        parcel.writeInt(this.mTargetViewId);
        parcel.writeInt(this.mFullingColorId);
        parcel.writeByte((byte) (this.mAutoDismiss ? 1 : 0));
        parcel.writeByte((byte) (this.mOverlayTarget ? 1 : 0));
    }
}

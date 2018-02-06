package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.RestrictTo;
import android.support.v4.media.d;
import android.support.v4.media.e;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public final class MediaDescriptionCompat implements Parcelable {
    public static final long BT_FOLDER_TYPE_ALBUMS = 2;
    public static final long BT_FOLDER_TYPE_ARTISTS = 3;
    public static final long BT_FOLDER_TYPE_GENRES = 4;
    public static final long BT_FOLDER_TYPE_MIXED = 0;
    public static final long BT_FOLDER_TYPE_PLAYLISTS = 5;
    public static final long BT_FOLDER_TYPE_TITLES = 1;
    public static final long BT_FOLDER_TYPE_YEARS = 6;
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new Parcelable.Creator<MediaDescriptionCompat>() { // from class: android.support.v4.media.MediaDescriptionCompat.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: e */
        public MediaDescriptionCompat createFromParcel(Parcel parcel) {
            return Build.VERSION.SDK_INT < 21 ? new MediaDescriptionCompat(parcel) : MediaDescriptionCompat.fromMediaDescription(d.f(parcel));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: af */
        public MediaDescriptionCompat[] newArray(int i) {
            return new MediaDescriptionCompat[i];
        }
    };
    @RestrictTo
    public static final String DESCRIPTION_KEY_MEDIA_URI = "android.support.v4.media.description.MEDIA_URI";
    @RestrictTo
    public static final String DESCRIPTION_KEY_NULL_BUNDLE_FLAG = "android.support.v4.media.description.NULL_BUNDLE_FLAG";
    public static final String EXTRA_BT_FOLDER_TYPE = "android.media.extra.BT_FOLDER_TYPE";
    private final Bundle mExtras;
    private final CharSequence mTitle;
    private final String xc;
    private final CharSequence yl;
    private final CharSequence ym;
    private final Bitmap yn;
    private final Uri yo;
    private final Uri yp;
    private Object yq;

    MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.xc = str;
        this.mTitle = charSequence;
        this.yl = charSequence2;
        this.ym = charSequence3;
        this.yn = bitmap;
        this.yo = uri;
        this.mExtras = bundle;
        this.yp = uri2;
    }

    MediaDescriptionCompat(Parcel parcel) {
        this.xc = parcel.readString();
        this.mTitle = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.yl = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.ym = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.yn = (Bitmap) parcel.readParcelable(null);
        this.yo = (Uri) parcel.readParcelable(null);
        this.mExtras = parcel.readBundle();
        this.yp = (Uri) parcel.readParcelable(null);
    }

    public String getMediaId() {
        return this.xc;
    }

    public CharSequence getTitle() {
        return this.mTitle;
    }

    public CharSequence getSubtitle() {
        return this.yl;
    }

    public CharSequence getDescription() {
        return this.ym;
    }

    public Bitmap getIconBitmap() {
        return this.yn;
    }

    public Uri getIconUri() {
        return this.yo;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public Uri getMediaUri() {
        return this.yp;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (Build.VERSION.SDK_INT < 21) {
            parcel.writeString(this.xc);
            TextUtils.writeToParcel(this.mTitle, parcel, i);
            TextUtils.writeToParcel(this.yl, parcel, i);
            TextUtils.writeToParcel(this.ym, parcel, i);
            parcel.writeParcelable(this.yn, i);
            parcel.writeParcelable(this.yo, i);
            parcel.writeBundle(this.mExtras);
            parcel.writeParcelable(this.yp, i);
            return;
        }
        d.a(getMediaDescription(), parcel, i);
    }

    public String toString() {
        return ((Object) this.mTitle) + ", " + ((Object) this.yl) + ", " + ((Object) this.ym);
    }

    public Object getMediaDescription() {
        if (this.yq != null || Build.VERSION.SDK_INT < 21) {
            return this.yq;
        }
        Object newInstance = d.a.newInstance();
        d.a.f(newInstance, this.xc);
        d.a.a(newInstance, this.mTitle);
        d.a.b(newInstance, this.yl);
        d.a.c(newInstance, this.ym);
        d.a.a(newInstance, this.yn);
        d.a.a(newInstance, this.yo);
        Bundle bundle = this.mExtras;
        if (Build.VERSION.SDK_INT < 23 && this.yp != null) {
            if (bundle == null) {
                bundle = new Bundle();
                bundle.putBoolean(DESCRIPTION_KEY_NULL_BUNDLE_FLAG, true);
            }
            bundle.putParcelable(DESCRIPTION_KEY_MEDIA_URI, this.yp);
        }
        d.a.a(newInstance, bundle);
        if (Build.VERSION.SDK_INT >= 23) {
            e.a.b(newInstance, this.yp);
        }
        this.yq = d.a.build(newInstance);
        return this.yq;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static MediaDescriptionCompat fromMediaDescription(Object obj) {
        Bundle bundle;
        if (obj == null || Build.VERSION.SDK_INT < 21) {
            return null;
        }
        Builder builder = new Builder();
        builder.setMediaId(d.u(obj));
        builder.setTitle(d.getTitle(obj));
        builder.setSubtitle(d.v(obj));
        builder.setDescription(d.w(obj));
        builder.setIconBitmap(d.x(obj));
        builder.setIconUri(d.y(obj));
        Bundle extras = d.getExtras(obj);
        Uri uri = extras == null ? null : (Uri) extras.getParcelable(DESCRIPTION_KEY_MEDIA_URI);
        if (uri != null) {
            if (!extras.containsKey(DESCRIPTION_KEY_NULL_BUNDLE_FLAG) || extras.size() != 2) {
                extras.remove(DESCRIPTION_KEY_MEDIA_URI);
                extras.remove(DESCRIPTION_KEY_NULL_BUNDLE_FLAG);
            } else {
                bundle = null;
                builder.setExtras(bundle);
                if (uri == null) {
                    builder.setMediaUri(uri);
                } else if (Build.VERSION.SDK_INT >= 23) {
                    builder.setMediaUri(e.z(obj));
                }
                MediaDescriptionCompat build = builder.build();
                build.yq = obj;
                return build;
            }
        }
        bundle = extras;
        builder.setExtras(bundle);
        if (uri == null) {
        }
        MediaDescriptionCompat build2 = builder.build();
        build2.yq = obj;
        return build2;
    }

    /* loaded from: classes2.dex */
    public static final class Builder {
        private Bundle mExtras;
        private CharSequence mTitle;
        private String xc;
        private CharSequence yl;
        private CharSequence ym;
        private Bitmap yn;
        private Uri yo;
        private Uri yp;

        public Builder setMediaId(String str) {
            this.xc = str;
            return this;
        }

        public Builder setTitle(CharSequence charSequence) {
            this.mTitle = charSequence;
            return this;
        }

        public Builder setSubtitle(CharSequence charSequence) {
            this.yl = charSequence;
            return this;
        }

        public Builder setDescription(CharSequence charSequence) {
            this.ym = charSequence;
            return this;
        }

        public Builder setIconBitmap(Bitmap bitmap) {
            this.yn = bitmap;
            return this;
        }

        public Builder setIconUri(Uri uri) {
            this.yo = uri;
            return this;
        }

        public Builder setExtras(Bundle bundle) {
            this.mExtras = bundle;
            return this;
        }

        public Builder setMediaUri(Uri uri) {
            this.yp = uri;
            return this;
        }

        public MediaDescriptionCompat build() {
            return new MediaDescriptionCompat(this.xc, this.mTitle, this.yl, this.ym, this.yn, this.yo, this.mExtras, this.yp);
        }
    }
}

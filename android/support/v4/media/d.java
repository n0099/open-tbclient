package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
/* loaded from: classes2.dex */
class d {
    public static String u(Object obj) {
        return ((MediaDescription) obj).getMediaId();
    }

    public static CharSequence getTitle(Object obj) {
        return ((MediaDescription) obj).getTitle();
    }

    public static CharSequence v(Object obj) {
        return ((MediaDescription) obj).getSubtitle();
    }

    public static CharSequence w(Object obj) {
        return ((MediaDescription) obj).getDescription();
    }

    public static Bitmap x(Object obj) {
        return ((MediaDescription) obj).getIconBitmap();
    }

    public static Uri y(Object obj) {
        return ((MediaDescription) obj).getIconUri();
    }

    public static Bundle getExtras(Object obj) {
        return ((MediaDescription) obj).getExtras();
    }

    public static void a(Object obj, Parcel parcel, int i) {
        ((MediaDescription) obj).writeToParcel(parcel, i);
    }

    public static Object f(Parcel parcel) {
        return MediaDescription.CREATOR.createFromParcel(parcel);
    }

    /* loaded from: classes2.dex */
    static class a {
        public static Object newInstance() {
            return new MediaDescription.Builder();
        }

        public static void f(Object obj, String str) {
            ((MediaDescription.Builder) obj).setMediaId(str);
        }

        public static void a(Object obj, CharSequence charSequence) {
            ((MediaDescription.Builder) obj).setTitle(charSequence);
        }

        public static void b(Object obj, CharSequence charSequence) {
            ((MediaDescription.Builder) obj).setSubtitle(charSequence);
        }

        public static void c(Object obj, CharSequence charSequence) {
            ((MediaDescription.Builder) obj).setDescription(charSequence);
        }

        public static void a(Object obj, Bitmap bitmap) {
            ((MediaDescription.Builder) obj).setIconBitmap(bitmap);
        }

        public static void a(Object obj, Uri uri) {
            ((MediaDescription.Builder) obj).setIconUri(uri);
        }

        public static void a(Object obj, Bundle bundle) {
            ((MediaDescription.Builder) obj).setExtras(bundle);
        }

        public static Object build(Object obj) {
            return ((MediaDescription.Builder) obj).build();
        }
    }
}

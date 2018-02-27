package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.RestrictTo;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Log;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Set;
/* loaded from: classes2.dex */
public final class MediaMetadataCompat implements Parcelable {
    public static final Parcelable.Creator<MediaMetadataCompat> CREATOR;
    public static final String METADATA_KEY_ALBUM = "android.media.metadata.ALBUM";
    public static final String METADATA_KEY_ALBUM_ART = "android.media.metadata.ALBUM_ART";
    public static final String METADATA_KEY_ALBUM_ARTIST = "android.media.metadata.ALBUM_ARTIST";
    public static final String METADATA_KEY_ALBUM_ART_URI = "android.media.metadata.ALBUM_ART_URI";
    public static final String METADATA_KEY_ART = "android.media.metadata.ART";
    public static final String METADATA_KEY_ARTIST = "android.media.metadata.ARTIST";
    public static final String METADATA_KEY_ART_URI = "android.media.metadata.ART_URI";
    public static final String METADATA_KEY_AUTHOR = "android.media.metadata.AUTHOR";
    public static final String METADATA_KEY_BT_FOLDER_TYPE = "android.media.metadata.BT_FOLDER_TYPE";
    public static final String METADATA_KEY_COMPILATION = "android.media.metadata.COMPILATION";
    public static final String METADATA_KEY_COMPOSER = "android.media.metadata.COMPOSER";
    public static final String METADATA_KEY_DATE = "android.media.metadata.DATE";
    public static final String METADATA_KEY_DISC_NUMBER = "android.media.metadata.DISC_NUMBER";
    public static final String METADATA_KEY_DISPLAY_DESCRIPTION = "android.media.metadata.DISPLAY_DESCRIPTION";
    public static final String METADATA_KEY_DISPLAY_ICON = "android.media.metadata.DISPLAY_ICON";
    public static final String METADATA_KEY_DISPLAY_ICON_URI = "android.media.metadata.DISPLAY_ICON_URI";
    public static final String METADATA_KEY_DISPLAY_SUBTITLE = "android.media.metadata.DISPLAY_SUBTITLE";
    public static final String METADATA_KEY_DISPLAY_TITLE = "android.media.metadata.DISPLAY_TITLE";
    public static final String METADATA_KEY_DURATION = "android.media.metadata.DURATION";
    public static final String METADATA_KEY_GENRE = "android.media.metadata.GENRE";
    public static final String METADATA_KEY_MEDIA_ID = "android.media.metadata.MEDIA_ID";
    public static final String METADATA_KEY_MEDIA_URI = "android.media.metadata.MEDIA_URI";
    public static final String METADATA_KEY_NUM_TRACKS = "android.media.metadata.NUM_TRACKS";
    public static final String METADATA_KEY_RATING = "android.media.metadata.RATING";
    public static final String METADATA_KEY_TITLE = "android.media.metadata.TITLE";
    public static final String METADATA_KEY_TRACK_NUMBER = "android.media.metadata.TRACK_NUMBER";
    public static final String METADATA_KEY_USER_RATING = "android.media.metadata.USER_RATING";
    public static final String METADATA_KEY_WRITER = "android.media.metadata.WRITER";
    public static final String METADATA_KEY_YEAR = "android.media.metadata.YEAR";
    static final ArrayMap<String, Integer> ym = new ArrayMap<>();
    private static final String[] yn;
    private static final String[] yo;
    private static final String[] yp;
    private MediaDescriptionCompat xs;
    final Bundle yq;
    private Object yr;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    /* loaded from: classes2.dex */
    public @interface BitmapKey {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    /* loaded from: classes2.dex */
    public @interface LongKey {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    /* loaded from: classes2.dex */
    public @interface RatingKey {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    /* loaded from: classes2.dex */
    public @interface TextKey {
    }

    static {
        ym.put(METADATA_KEY_TITLE, 1);
        ym.put(METADATA_KEY_ARTIST, 1);
        ym.put(METADATA_KEY_DURATION, 0);
        ym.put(METADATA_KEY_ALBUM, 1);
        ym.put(METADATA_KEY_AUTHOR, 1);
        ym.put(METADATA_KEY_WRITER, 1);
        ym.put(METADATA_KEY_COMPOSER, 1);
        ym.put(METADATA_KEY_COMPILATION, 1);
        ym.put(METADATA_KEY_DATE, 1);
        ym.put(METADATA_KEY_YEAR, 0);
        ym.put(METADATA_KEY_GENRE, 1);
        ym.put(METADATA_KEY_TRACK_NUMBER, 0);
        ym.put(METADATA_KEY_NUM_TRACKS, 0);
        ym.put(METADATA_KEY_DISC_NUMBER, 0);
        ym.put(METADATA_KEY_ALBUM_ARTIST, 1);
        ym.put(METADATA_KEY_ART, 2);
        ym.put(METADATA_KEY_ART_URI, 1);
        ym.put(METADATA_KEY_ALBUM_ART, 2);
        ym.put(METADATA_KEY_ALBUM_ART_URI, 1);
        ym.put(METADATA_KEY_USER_RATING, 3);
        ym.put(METADATA_KEY_RATING, 3);
        ym.put(METADATA_KEY_DISPLAY_TITLE, 1);
        ym.put(METADATA_KEY_DISPLAY_SUBTITLE, 1);
        ym.put(METADATA_KEY_DISPLAY_DESCRIPTION, 1);
        ym.put(METADATA_KEY_DISPLAY_ICON, 2);
        ym.put(METADATA_KEY_DISPLAY_ICON_URI, 1);
        ym.put(METADATA_KEY_MEDIA_ID, 1);
        ym.put(METADATA_KEY_BT_FOLDER_TYPE, 0);
        ym.put(METADATA_KEY_MEDIA_URI, 1);
        yn = new String[]{METADATA_KEY_TITLE, METADATA_KEY_ARTIST, METADATA_KEY_ALBUM, METADATA_KEY_ALBUM_ARTIST, METADATA_KEY_WRITER, METADATA_KEY_AUTHOR, METADATA_KEY_COMPOSER};
        yo = new String[]{METADATA_KEY_DISPLAY_ICON, METADATA_KEY_ART, METADATA_KEY_ALBUM_ART};
        yp = new String[]{METADATA_KEY_DISPLAY_ICON_URI, METADATA_KEY_ART_URI, METADATA_KEY_ALBUM_ART_URI};
        CREATOR = new Parcelable.Creator<MediaMetadataCompat>() { // from class: android.support.v4.media.MediaMetadataCompat.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: g */
            public MediaMetadataCompat createFromParcel(Parcel parcel) {
                return new MediaMetadataCompat(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: ag */
            public MediaMetadataCompat[] newArray(int i) {
                return new MediaMetadataCompat[i];
            }
        };
    }

    MediaMetadataCompat(Bundle bundle) {
        this.yq = new Bundle(bundle);
    }

    MediaMetadataCompat(Parcel parcel) {
        this.yq = parcel.readBundle();
    }

    public boolean containsKey(String str) {
        return this.yq.containsKey(str);
    }

    public CharSequence getText(String str) {
        return this.yq.getCharSequence(str);
    }

    public String getString(String str) {
        CharSequence charSequence = this.yq.getCharSequence(str);
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public long getLong(String str) {
        return this.yq.getLong(str, 0L);
    }

    public RatingCompat getRating(String str) {
        RatingCompat ratingCompat;
        try {
            if (Build.VERSION.SDK_INT >= 19) {
                ratingCompat = RatingCompat.fromRating(this.yq.getParcelable(str));
            } else {
                ratingCompat = (RatingCompat) this.yq.getParcelable(str);
            }
            return ratingCompat;
        } catch (Exception e) {
            Log.w("MediaMetadata", "Failed to retrieve a key as Rating.", e);
            return null;
        }
    }

    public Bitmap getBitmap(String str) {
        try {
            return (Bitmap) this.yq.getParcelable(str);
        } catch (Exception e) {
            Log.w("MediaMetadata", "Failed to retrieve a key as Bitmap.", e);
            return null;
        }
    }

    public MediaDescriptionCompat getDescription() {
        int i;
        Bitmap bitmap;
        Uri uri;
        if (this.xs != null) {
            return this.xs;
        }
        String string = getString(METADATA_KEY_MEDIA_ID);
        CharSequence[] charSequenceArr = new CharSequence[3];
        CharSequence text = getText(METADATA_KEY_DISPLAY_TITLE);
        if (!TextUtils.isEmpty(text)) {
            charSequenceArr[0] = text;
            charSequenceArr[1] = getText(METADATA_KEY_DISPLAY_SUBTITLE);
            charSequenceArr[2] = getText(METADATA_KEY_DISPLAY_DESCRIPTION);
        } else {
            int i2 = 0;
            int i3 = 0;
            while (i3 < charSequenceArr.length && i2 < yn.length) {
                int i4 = i2 + 1;
                CharSequence text2 = getText(yn[i2]);
                if (TextUtils.isEmpty(text2)) {
                    i = i3;
                } else {
                    i = i3 + 1;
                    charSequenceArr[i3] = text2;
                }
                i3 = i;
                i2 = i4;
            }
        }
        int i5 = 0;
        while (true) {
            if (i5 >= yo.length) {
                bitmap = null;
                break;
            }
            Bitmap bitmap2 = getBitmap(yo[i5]);
            if (bitmap2 != null) {
                bitmap = bitmap2;
                break;
            }
            i5++;
        }
        int i6 = 0;
        while (true) {
            if (i6 >= yp.length) {
                uri = null;
                break;
            }
            String string2 = getString(yp[i6]);
            if (TextUtils.isEmpty(string2)) {
                i6++;
            } else {
                uri = Uri.parse(string2);
                break;
            }
        }
        String string3 = getString(METADATA_KEY_MEDIA_URI);
        Uri parse = TextUtils.isEmpty(string3) ? null : Uri.parse(string3);
        MediaDescriptionCompat.Builder builder = new MediaDescriptionCompat.Builder();
        builder.setMediaId(string);
        builder.setTitle(charSequenceArr[0]);
        builder.setSubtitle(charSequenceArr[1]);
        builder.setDescription(charSequenceArr[2]);
        builder.setIconBitmap(bitmap);
        builder.setIconUri(uri);
        builder.setMediaUri(parse);
        if (this.yq.containsKey(METADATA_KEY_BT_FOLDER_TYPE)) {
            Bundle bundle = new Bundle();
            bundle.putLong(MediaDescriptionCompat.EXTRA_BT_FOLDER_TYPE, getLong(METADATA_KEY_BT_FOLDER_TYPE));
            builder.setExtras(bundle);
        }
        this.xs = builder.build();
        return this.xs;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.yq);
    }

    public int size() {
        return this.yq.size();
    }

    public Set<String> keySet() {
        return this.yq.keySet();
    }

    public Bundle getBundle() {
        return this.yq;
    }

    public static MediaMetadataCompat fromMediaMetadata(Object obj) {
        if (obj == null || Build.VERSION.SDK_INT < 21) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        MediaMetadataCompatApi21.a(obj, obtain, 0);
        obtain.setDataPosition(0);
        MediaMetadataCompat createFromParcel = CREATOR.createFromParcel(obtain);
        obtain.recycle();
        createFromParcel.yr = obj;
        return createFromParcel;
    }

    public Object getMediaMetadata() {
        if (this.yr != null || Build.VERSION.SDK_INT < 21) {
            return this.yr;
        }
        Parcel obtain = Parcel.obtain();
        writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        this.yr = MediaMetadataCompatApi21.createFromParcel(obtain);
        obtain.recycle();
        return this.yr;
    }

    /* loaded from: classes2.dex */
    public static final class Builder {
        private final Bundle yq;

        public Builder() {
            this.yq = new Bundle();
        }

        public Builder(MediaMetadataCompat mediaMetadataCompat) {
            this.yq = new Bundle(mediaMetadataCompat.yq);
        }

        @RestrictTo
        public Builder(MediaMetadataCompat mediaMetadataCompat, int i) {
            this(mediaMetadataCompat);
            for (String str : this.yq.keySet()) {
                Object obj = this.yq.get(str);
                if (obj != null && (obj instanceof Bitmap)) {
                    Bitmap bitmap = (Bitmap) obj;
                    if (bitmap.getHeight() > i || bitmap.getWidth() > i) {
                        putBitmap(str, b(bitmap, i));
                    } else if (Build.VERSION.SDK_INT >= 14 && (str.equals(MediaMetadataCompat.METADATA_KEY_ART) || str.equals(MediaMetadataCompat.METADATA_KEY_ALBUM_ART))) {
                        putBitmap(str, bitmap.copy(bitmap.getConfig(), false));
                    }
                }
            }
        }

        public Builder putText(String str, CharSequence charSequence) {
            if (MediaMetadataCompat.ym.containsKey(str) && MediaMetadataCompat.ym.get(str).intValue() != 1) {
                throw new IllegalArgumentException("The " + str + " key cannot be used to put a CharSequence");
            }
            this.yq.putCharSequence(str, charSequence);
            return this;
        }

        public Builder putString(String str, String str2) {
            if (MediaMetadataCompat.ym.containsKey(str) && MediaMetadataCompat.ym.get(str).intValue() != 1) {
                throw new IllegalArgumentException("The " + str + " key cannot be used to put a String");
            }
            this.yq.putCharSequence(str, str2);
            return this;
        }

        public Builder putLong(String str, long j) {
            if (MediaMetadataCompat.ym.containsKey(str) && MediaMetadataCompat.ym.get(str).intValue() != 0) {
                throw new IllegalArgumentException("The " + str + " key cannot be used to put a long");
            }
            this.yq.putLong(str, j);
            return this;
        }

        public Builder putRating(String str, RatingCompat ratingCompat) {
            if (MediaMetadataCompat.ym.containsKey(str) && MediaMetadataCompat.ym.get(str).intValue() != 3) {
                throw new IllegalArgumentException("The " + str + " key cannot be used to put a Rating");
            }
            if (Build.VERSION.SDK_INT >= 19) {
                this.yq.putParcelable(str, (Parcelable) ratingCompat.getRating());
            } else {
                this.yq.putParcelable(str, ratingCompat);
            }
            return this;
        }

        public Builder putBitmap(String str, Bitmap bitmap) {
            if (MediaMetadataCompat.ym.containsKey(str) && MediaMetadataCompat.ym.get(str).intValue() != 2) {
                throw new IllegalArgumentException("The " + str + " key cannot be used to put a Bitmap");
            }
            this.yq.putParcelable(str, bitmap);
            return this;
        }

        public MediaMetadataCompat build() {
            return new MediaMetadataCompat(this.yq);
        }

        private Bitmap b(Bitmap bitmap, int i) {
            float f = i;
            float min = Math.min(f / bitmap.getWidth(), f / bitmap.getHeight());
            return Bitmap.createScaledBitmap(bitmap, (int) (min * bitmap.getWidth()), (int) (bitmap.getHeight() * min), true);
        }
    }
}

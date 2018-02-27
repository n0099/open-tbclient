package android.support.v4.media.session;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.annotation.RestrictTo;
import android.support.v4.media.TransportMediator;
import android.support.v4.media.session.f;
import android.text.TextUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class PlaybackStateCompat implements Parcelable {
    public static final long ACTION_FAST_FORWARD = 64;
    public static final long ACTION_PAUSE = 2;
    public static final long ACTION_PLAY = 4;
    public static final long ACTION_PLAY_FROM_MEDIA_ID = 1024;
    public static final long ACTION_PLAY_FROM_SEARCH = 2048;
    public static final long ACTION_PLAY_FROM_URI = 8192;
    public static final long ACTION_PLAY_PAUSE = 512;
    public static final long ACTION_PREPARE = 16384;
    public static final long ACTION_PREPARE_FROM_MEDIA_ID = 32768;
    public static final long ACTION_PREPARE_FROM_SEARCH = 65536;
    public static final long ACTION_PREPARE_FROM_URI = 131072;
    public static final long ACTION_REWIND = 8;
    public static final long ACTION_SEEK_TO = 256;
    public static final long ACTION_SET_RATING = 128;
    public static final long ACTION_SKIP_TO_NEXT = 32;
    public static final long ACTION_SKIP_TO_PREVIOUS = 16;
    public static final long ACTION_SKIP_TO_QUEUE_ITEM = 4096;
    public static final long ACTION_STOP = 1;
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new Parcelable.Creator<PlaybackStateCompat>() { // from class: android.support.v4.media.session.PlaybackStateCompat.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: m */
        public PlaybackStateCompat createFromParcel(Parcel parcel) {
            return new PlaybackStateCompat(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: ar */
        public PlaybackStateCompat[] newArray(int i) {
            return new PlaybackStateCompat[i];
        }
    };
    public static final long PLAYBACK_POSITION_UNKNOWN = -1;
    public static final int STATE_BUFFERING = 6;
    public static final int STATE_CONNECTING = 8;
    public static final int STATE_ERROR = 7;
    public static final int STATE_FAST_FORWARDING = 4;
    public static final int STATE_NONE = 0;
    public static final int STATE_PAUSED = 2;
    public static final int STATE_PLAYING = 3;
    public static final int STATE_REWINDING = 5;
    public static final int STATE_SKIPPING_TO_NEXT = 10;
    public static final int STATE_SKIPPING_TO_PREVIOUS = 9;
    public static final int STATE_SKIPPING_TO_QUEUE_ITEM = 11;
    public static final int STATE_STOPPED = 1;
    List<CustomAction> Aa;
    final long Ab;
    private Object Ac;
    final Bundle mExtras;
    final float mSpeed;
    final int mState;
    final long zV;
    final long zW;
    final long zX;
    final CharSequence zY;
    final long zZ;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    /* loaded from: classes2.dex */
    public @interface Actions {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    /* loaded from: classes2.dex */
    public @interface MediaKeyAction {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    /* loaded from: classes2.dex */
    public @interface State {
    }

    public static int toKeyCode(long j) {
        if (j == 4) {
            return TransportMediator.KEYCODE_MEDIA_PLAY;
        }
        if (j == 2) {
            return TransportMediator.KEYCODE_MEDIA_PAUSE;
        }
        if (j == 32) {
            return 87;
        }
        if (j == 16) {
            return 88;
        }
        if (j == 1) {
            return 86;
        }
        if (j == 64) {
            return 90;
        }
        if (j == 8) {
            return 89;
        }
        if (j == 512) {
            return 85;
        }
        return 0;
    }

    PlaybackStateCompat(int i, long j, long j2, float f, long j3, CharSequence charSequence, long j4, List<CustomAction> list, long j5, Bundle bundle) {
        this.mState = i;
        this.zV = j;
        this.zW = j2;
        this.mSpeed = f;
        this.zX = j3;
        this.zY = charSequence;
        this.zZ = j4;
        this.Aa = new ArrayList(list);
        this.Ab = j5;
        this.mExtras = bundle;
    }

    PlaybackStateCompat(Parcel parcel) {
        this.mState = parcel.readInt();
        this.zV = parcel.readLong();
        this.mSpeed = parcel.readFloat();
        this.zZ = parcel.readLong();
        this.zW = parcel.readLong();
        this.zX = parcel.readLong();
        this.zY = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.Aa = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.Ab = parcel.readLong();
        this.mExtras = parcel.readBundle();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PlaybackState {");
        sb.append("state=").append(this.mState);
        sb.append(", position=").append(this.zV);
        sb.append(", buffered position=").append(this.zW);
        sb.append(", speed=").append(this.mSpeed);
        sb.append(", updated=").append(this.zZ);
        sb.append(", actions=").append(this.zX);
        sb.append(", error=").append(this.zY);
        sb.append(", custom actions=").append(this.Aa);
        sb.append(", active item id=").append(this.Ab);
        sb.append("}");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mState);
        parcel.writeLong(this.zV);
        parcel.writeFloat(this.mSpeed);
        parcel.writeLong(this.zZ);
        parcel.writeLong(this.zW);
        parcel.writeLong(this.zX);
        TextUtils.writeToParcel(this.zY, parcel, i);
        parcel.writeTypedList(this.Aa);
        parcel.writeLong(this.Ab);
        parcel.writeBundle(this.mExtras);
    }

    public int getState() {
        return this.mState;
    }

    public long getPosition() {
        return this.zV;
    }

    public long getBufferedPosition() {
        return this.zW;
    }

    public float getPlaybackSpeed() {
        return this.mSpeed;
    }

    public long getActions() {
        return this.zX;
    }

    public List<CustomAction> getCustomActions() {
        return this.Aa;
    }

    public CharSequence getErrorMessage() {
        return this.zY;
    }

    public long getLastPositionUpdateTime() {
        return this.zZ;
    }

    public long getActiveQueueItemId() {
        return this.Ab;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public static PlaybackStateCompat fromPlaybackState(Object obj) {
        if (obj == null || Build.VERSION.SDK_INT < 21) {
            return null;
        }
        List<Object> ae = f.ae(obj);
        ArrayList arrayList = null;
        if (ae != null) {
            arrayList = new ArrayList(ae.size());
            for (Object obj2 : ae) {
                arrayList.add(CustomAction.fromCustomAction(obj2));
            }
        }
        PlaybackStateCompat playbackStateCompat = new PlaybackStateCompat(f.X(obj), f.Y(obj), f.Z(obj), f.aa(obj), f.ab(obj), f.ac(obj), f.ad(obj), arrayList, f.af(obj), Build.VERSION.SDK_INT >= 22 ? g.getExtras(obj) : null);
        playbackStateCompat.Ac = obj;
        return playbackStateCompat;
    }

    public Object getPlaybackState() {
        if (this.Ac != null || Build.VERSION.SDK_INT < 21) {
            return this.Ac;
        }
        ArrayList arrayList = null;
        if (this.Aa != null) {
            arrayList = new ArrayList(this.Aa.size());
            for (CustomAction customAction : this.Aa) {
                arrayList.add(customAction.getCustomAction());
            }
        }
        if (Build.VERSION.SDK_INT >= 22) {
            this.Ac = g.a(this.mState, this.zV, this.zW, this.mSpeed, this.zX, this.zY, this.zZ, arrayList, this.Ab, this.mExtras);
        } else {
            this.Ac = f.a(this.mState, this.zV, this.zW, this.mSpeed, this.zX, this.zY, this.zZ, arrayList, this.Ab);
        }
        return this.Ac;
    }

    /* loaded from: classes2.dex */
    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new Parcelable.Creator<CustomAction>() { // from class: android.support.v4.media.session.PlaybackStateCompat.CustomAction.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: n */
            public CustomAction createFromParcel(Parcel parcel) {
                return new CustomAction(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: as */
            public CustomAction[] newArray(int i) {
                return new CustomAction[i];
            }
        };
        private final String Af;
        private final CharSequence Ag;
        private Object Ah;
        private final Bundle mExtras;
        private final int mIcon;

        CustomAction(String str, CharSequence charSequence, int i, Bundle bundle) {
            this.Af = str;
            this.Ag = charSequence;
            this.mIcon = i;
            this.mExtras = bundle;
        }

        CustomAction(Parcel parcel) {
            this.Af = parcel.readString();
            this.Ag = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.mIcon = parcel.readInt();
            this.mExtras = parcel.readBundle();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.Af);
            TextUtils.writeToParcel(this.Ag, parcel, i);
            parcel.writeInt(this.mIcon);
            parcel.writeBundle(this.mExtras);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public static CustomAction fromCustomAction(Object obj) {
            if (obj == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            CustomAction customAction = new CustomAction(f.a.ag(obj), f.a.ah(obj), f.a.ai(obj), f.a.getExtras(obj));
            customAction.Ah = obj;
            return customAction;
        }

        public Object getCustomAction() {
            if (this.Ah != null || Build.VERSION.SDK_INT < 21) {
                return this.Ah;
            }
            this.Ah = f.a.a(this.Af, this.Ag, this.mIcon, this.mExtras);
            return this.Ah;
        }

        public String getAction() {
            return this.Af;
        }

        public CharSequence getName() {
            return this.Ag;
        }

        public int getIcon() {
            return this.mIcon;
        }

        public Bundle getExtras() {
            return this.mExtras;
        }

        public String toString() {
            return "Action:mName='" + ((Object) this.Ag) + ", mIcon=" + this.mIcon + ", mExtras=" + this.mExtras;
        }

        /* loaded from: classes2.dex */
        public static final class Builder {
            private final String Af;
            private final CharSequence Ag;
            private Bundle mExtras;
            private final int mIcon;

            public Builder(String str, CharSequence charSequence, int i) {
                if (TextUtils.isEmpty(str)) {
                    throw new IllegalArgumentException("You must specify an action to build a CustomAction.");
                }
                if (TextUtils.isEmpty(charSequence)) {
                    throw new IllegalArgumentException("You must specify a name to build a CustomAction.");
                }
                if (i == 0) {
                    throw new IllegalArgumentException("You must specify an icon resource id to build a CustomAction.");
                }
                this.Af = str;
                this.Ag = charSequence;
                this.mIcon = i;
            }

            public Builder setExtras(Bundle bundle) {
                this.mExtras = bundle;
                return this;
            }

            public CustomAction build() {
                return new CustomAction(this.Af, this.Ag, this.mIcon, this.mExtras);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class Builder {
        private final List<CustomAction> Aa;
        private long Ab;
        private float Ae;
        private Bundle mExtras;
        private int mState;
        private long zV;
        private long zW;
        private long zX;
        private CharSequence zY;
        private long zZ;

        public Builder() {
            this.Aa = new ArrayList();
            this.Ab = -1L;
        }

        public Builder(PlaybackStateCompat playbackStateCompat) {
            this.Aa = new ArrayList();
            this.Ab = -1L;
            this.mState = playbackStateCompat.mState;
            this.zV = playbackStateCompat.zV;
            this.Ae = playbackStateCompat.mSpeed;
            this.zZ = playbackStateCompat.zZ;
            this.zW = playbackStateCompat.zW;
            this.zX = playbackStateCompat.zX;
            this.zY = playbackStateCompat.zY;
            if (playbackStateCompat.Aa != null) {
                this.Aa.addAll(playbackStateCompat.Aa);
            }
            this.Ab = playbackStateCompat.Ab;
            this.mExtras = playbackStateCompat.mExtras;
        }

        public Builder setState(int i, long j, float f) {
            return setState(i, j, f, SystemClock.elapsedRealtime());
        }

        public Builder setState(int i, long j, float f, long j2) {
            this.mState = i;
            this.zV = j;
            this.zZ = j2;
            this.Ae = f;
            return this;
        }

        public Builder setBufferedPosition(long j) {
            this.zW = j;
            return this;
        }

        public Builder setActions(long j) {
            this.zX = j;
            return this;
        }

        public Builder addCustomAction(String str, String str2, int i) {
            return addCustomAction(new CustomAction(str, str2, i, null));
        }

        public Builder addCustomAction(CustomAction customAction) {
            if (customAction == null) {
                throw new IllegalArgumentException("You may not add a null CustomAction to PlaybackStateCompat.");
            }
            this.Aa.add(customAction);
            return this;
        }

        public Builder setActiveQueueItemId(long j) {
            this.Ab = j;
            return this;
        }

        public Builder setErrorMessage(CharSequence charSequence) {
            this.zY = charSequence;
            return this;
        }

        public Builder setExtras(Bundle bundle) {
            this.mExtras = bundle;
            return this;
        }

        public PlaybackStateCompat build() {
            return new PlaybackStateCompat(this.mState, this.zV, this.zW, this.Ae, this.zX, this.zY, this.zZ, this.Aa, this.Ab, this.mExtras);
        }
    }
}

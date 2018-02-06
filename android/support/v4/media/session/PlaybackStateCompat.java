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
    final long Aa;
    final long Ab;
    final long Ac;
    final CharSequence Ae;
    final long Af;
    List<CustomAction> Ag;
    final long Ah;
    private Object Ai;
    final Bundle mExtras;
    final float mSpeed;
    final int mState;

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
        this.Aa = j;
        this.Ab = j2;
        this.mSpeed = f;
        this.Ac = j3;
        this.Ae = charSequence;
        this.Af = j4;
        this.Ag = new ArrayList(list);
        this.Ah = j5;
        this.mExtras = bundle;
    }

    PlaybackStateCompat(Parcel parcel) {
        this.mState = parcel.readInt();
        this.Aa = parcel.readLong();
        this.mSpeed = parcel.readFloat();
        this.Af = parcel.readLong();
        this.Ab = parcel.readLong();
        this.Ac = parcel.readLong();
        this.Ae = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.Ag = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.Ah = parcel.readLong();
        this.mExtras = parcel.readBundle();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PlaybackState {");
        sb.append("state=").append(this.mState);
        sb.append(", position=").append(this.Aa);
        sb.append(", buffered position=").append(this.Ab);
        sb.append(", speed=").append(this.mSpeed);
        sb.append(", updated=").append(this.Af);
        sb.append(", actions=").append(this.Ac);
        sb.append(", error=").append(this.Ae);
        sb.append(", custom actions=").append(this.Ag);
        sb.append(", active item id=").append(this.Ah);
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
        parcel.writeLong(this.Aa);
        parcel.writeFloat(this.mSpeed);
        parcel.writeLong(this.Af);
        parcel.writeLong(this.Ab);
        parcel.writeLong(this.Ac);
        TextUtils.writeToParcel(this.Ae, parcel, i);
        parcel.writeTypedList(this.Ag);
        parcel.writeLong(this.Ah);
        parcel.writeBundle(this.mExtras);
    }

    public int getState() {
        return this.mState;
    }

    public long getPosition() {
        return this.Aa;
    }

    public long getBufferedPosition() {
        return this.Ab;
    }

    public float getPlaybackSpeed() {
        return this.mSpeed;
    }

    public long getActions() {
        return this.Ac;
    }

    public List<CustomAction> getCustomActions() {
        return this.Ag;
    }

    public CharSequence getErrorMessage() {
        return this.Ae;
    }

    public long getLastPositionUpdateTime() {
        return this.Af;
    }

    public long getActiveQueueItemId() {
        return this.Ah;
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
        playbackStateCompat.Ai = obj;
        return playbackStateCompat;
    }

    public Object getPlaybackState() {
        if (this.Ai != null || Build.VERSION.SDK_INT < 21) {
            return this.Ai;
        }
        ArrayList arrayList = null;
        if (this.Ag != null) {
            arrayList = new ArrayList(this.Ag.size());
            for (CustomAction customAction : this.Ag) {
                arrayList.add(customAction.getCustomAction());
            }
        }
        if (Build.VERSION.SDK_INT >= 22) {
            this.Ai = g.a(this.mState, this.Aa, this.Ab, this.mSpeed, this.Ac, this.Ae, this.Af, arrayList, this.Ah, this.mExtras);
        } else {
            this.Ai = f.a(this.mState, this.Aa, this.Ab, this.mSpeed, this.Ac, this.Ae, this.Af, arrayList, this.Ah);
        }
        return this.Ai;
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
        private final String Ak;
        private final CharSequence Al;
        private Object Am;
        private final Bundle mExtras;
        private final int mIcon;

        CustomAction(String str, CharSequence charSequence, int i, Bundle bundle) {
            this.Ak = str;
            this.Al = charSequence;
            this.mIcon = i;
            this.mExtras = bundle;
        }

        CustomAction(Parcel parcel) {
            this.Ak = parcel.readString();
            this.Al = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.mIcon = parcel.readInt();
            this.mExtras = parcel.readBundle();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.Ak);
            TextUtils.writeToParcel(this.Al, parcel, i);
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
            customAction.Am = obj;
            return customAction;
        }

        public Object getCustomAction() {
            if (this.Am != null || Build.VERSION.SDK_INT < 21) {
                return this.Am;
            }
            this.Am = f.a.a(this.Ak, this.Al, this.mIcon, this.mExtras);
            return this.Am;
        }

        public String getAction() {
            return this.Ak;
        }

        public CharSequence getName() {
            return this.Al;
        }

        public int getIcon() {
            return this.mIcon;
        }

        public Bundle getExtras() {
            return this.mExtras;
        }

        public String toString() {
            return "Action:mName='" + ((Object) this.Al) + ", mIcon=" + this.mIcon + ", mExtras=" + this.mExtras;
        }

        /* loaded from: classes2.dex */
        public static final class Builder {
            private final String Ak;
            private final CharSequence Al;
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
                this.Ak = str;
                this.Al = charSequence;
                this.mIcon = i;
            }

            public Builder setExtras(Bundle bundle) {
                this.mExtras = bundle;
                return this;
            }

            public CustomAction build() {
                return new CustomAction(this.Ak, this.Al, this.mIcon, this.mExtras);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class Builder {
        private long Aa;
        private long Ab;
        private long Ac;
        private CharSequence Ae;
        private long Af;
        private final List<CustomAction> Ag;
        private long Ah;
        private float Aj;
        private Bundle mExtras;
        private int mState;

        public Builder() {
            this.Ag = new ArrayList();
            this.Ah = -1L;
        }

        public Builder(PlaybackStateCompat playbackStateCompat) {
            this.Ag = new ArrayList();
            this.Ah = -1L;
            this.mState = playbackStateCompat.mState;
            this.Aa = playbackStateCompat.Aa;
            this.Aj = playbackStateCompat.mSpeed;
            this.Af = playbackStateCompat.Af;
            this.Ab = playbackStateCompat.Ab;
            this.Ac = playbackStateCompat.Ac;
            this.Ae = playbackStateCompat.Ae;
            if (playbackStateCompat.Ag != null) {
                this.Ag.addAll(playbackStateCompat.Ag);
            }
            this.Ah = playbackStateCompat.Ah;
            this.mExtras = playbackStateCompat.mExtras;
        }

        public Builder setState(int i, long j, float f) {
            return setState(i, j, f, SystemClock.elapsedRealtime());
        }

        public Builder setState(int i, long j, float f, long j2) {
            this.mState = i;
            this.Aa = j;
            this.Af = j2;
            this.Aj = f;
            return this;
        }

        public Builder setBufferedPosition(long j) {
            this.Ab = j;
            return this;
        }

        public Builder setActions(long j) {
            this.Ac = j;
            return this;
        }

        public Builder addCustomAction(String str, String str2, int i) {
            return addCustomAction(new CustomAction(str, str2, i, null));
        }

        public Builder addCustomAction(CustomAction customAction) {
            if (customAction == null) {
                throw new IllegalArgumentException("You may not add a null CustomAction to PlaybackStateCompat.");
            }
            this.Ag.add(customAction);
            return this;
        }

        public Builder setActiveQueueItemId(long j) {
            this.Ah = j;
            return this;
        }

        public Builder setErrorMessage(CharSequence charSequence) {
            this.Ae = charSequence;
            return this;
        }

        public Builder setExtras(Bundle bundle) {
            this.mExtras = bundle;
            return this;
        }

        public PlaybackStateCompat build() {
            return new PlaybackStateCompat(this.mState, this.Aa, this.Ab, this.Aj, this.Ac, this.Ae, this.Af, this.Ag, this.Ah, this.mExtras);
        }
    }
}

package androidx.media2.session;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.ObjectsCompat;
import androidx.versionedparcelable.VersionedParcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class SessionCommand implements VersionedParcelable {
    public static final int COMMAND_CODE_CUSTOM = 0;
    public static final int COMMAND_CODE_LIBRARY_GET_CHILDREN = 50003;
    public static final int COMMAND_CODE_LIBRARY_GET_ITEM = 50004;
    public static final int COMMAND_CODE_LIBRARY_GET_LIBRARY_ROOT = 50000;
    public static final int COMMAND_CODE_LIBRARY_GET_SEARCH_RESULT = 50006;
    public static final int COMMAND_CODE_LIBRARY_SEARCH = 50005;
    public static final int COMMAND_CODE_LIBRARY_SUBSCRIBE = 50001;
    public static final int COMMAND_CODE_LIBRARY_UNSUBSCRIBE = 50002;
    public static final int COMMAND_CODE_PLAYER_ADD_PLAYLIST_ITEM = 10013;
    public static final int COMMAND_CODE_PLAYER_DESELECT_TRACK = 11002;
    public static final int COMMAND_CODE_PLAYER_GET_CURRENT_MEDIA_ITEM = 10016;
    public static final int COMMAND_CODE_PLAYER_GET_PLAYLIST = 10005;
    public static final int COMMAND_CODE_PLAYER_GET_PLAYLIST_METADATA = 10012;
    public static final int COMMAND_CODE_PLAYER_MOVE_PLAYLIST_ITEM = 10019;
    public static final int COMMAND_CODE_PLAYER_PAUSE = 10001;
    public static final int COMMAND_CODE_PLAYER_PLAY = 10000;
    public static final int COMMAND_CODE_PLAYER_PREPARE = 10002;
    public static final int COMMAND_CODE_PLAYER_REMOVE_PLAYLIST_ITEM = 10014;
    public static final int COMMAND_CODE_PLAYER_REPLACE_PLAYLIST_ITEM = 10015;
    public static final int COMMAND_CODE_PLAYER_SEEK_TO = 10003;
    public static final int COMMAND_CODE_PLAYER_SELECT_TRACK = 11001;
    public static final int COMMAND_CODE_PLAYER_SET_MEDIA_ITEM = 10018;
    public static final int COMMAND_CODE_PLAYER_SET_PLAYLIST = 10006;
    public static final int COMMAND_CODE_PLAYER_SET_REPEAT_MODE = 10011;
    public static final int COMMAND_CODE_PLAYER_SET_SHUFFLE_MODE = 10010;
    public static final int COMMAND_CODE_PLAYER_SET_SPEED = 10004;
    public static final int COMMAND_CODE_PLAYER_SET_SURFACE = 11000;
    public static final int COMMAND_CODE_PLAYER_SKIP_TO_NEXT_PLAYLIST_ITEM = 10009;
    public static final int COMMAND_CODE_PLAYER_SKIP_TO_PLAYLIST_ITEM = 10007;
    public static final int COMMAND_CODE_PLAYER_SKIP_TO_PREVIOUS_PLAYLIST_ITEM = 10008;
    public static final int COMMAND_CODE_PLAYER_UPDATE_LIST_METADATA = 10017;
    public static final int COMMAND_CODE_SESSION_FAST_FORWARD = 40000;
    public static final int COMMAND_CODE_SESSION_REWIND = 40001;
    public static final int COMMAND_CODE_SESSION_SET_MEDIA_URI = 40011;
    public static final int COMMAND_CODE_SESSION_SET_RATING = 40010;
    public static final int COMMAND_CODE_SESSION_SKIP_BACKWARD = 40003;
    public static final int COMMAND_CODE_SESSION_SKIP_FORWARD = 40002;
    public static final int COMMAND_CODE_VOLUME_ADJUST_VOLUME = 30001;
    public static final int COMMAND_CODE_VOLUME_SET_VOLUME = 30000;
    public static final int COMMAND_VERSION_1 = 1;
    public static final int COMMAND_VERSION_2 = 2;
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final int COMMAND_VERSION_CURRENT = 2;
    public static final SparseArray<List<Integer>> VERSION_LIBRARY_COMMANDS_MAP;
    public static final SparseArray<List<Integer>> VERSION_PLAYER_BASIC_COMMANDS_MAP = new SparseArray<>();
    public static final SparseArray<List<Integer>> VERSION_PLAYER_PLAYLIST_COMMANDS_MAP = new SparseArray<>();
    public static final SparseArray<List<Integer>> VERSION_SESSION_COMMANDS_MAP;
    public static final SparseArray<List<Integer>> VERSION_VOLUME_COMMANDS_MAP;
    public int mCommandCode;
    public String mCustomAction;
    public Bundle mCustomExtras;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public @interface CommandCode {
    }

    @SuppressLint({"UniqueConstants"})
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public @interface CommandVersion {
    }

    static {
        VERSION_PLAYER_BASIC_COMMANDS_MAP.put(1, Arrays.asList(10000, 10001, 10002, 10003, 10004, 11000, 11001, 11002));
        VERSION_PLAYER_PLAYLIST_COMMANDS_MAP.put(1, Arrays.asList(10005, 10006, 10007, 10008, 10009, 10010, 10011, 10012, 10013, 10014, 10015, Integer.valueOf((int) COMMAND_CODE_PLAYER_GET_CURRENT_MEDIA_ITEM), Integer.valueOf((int) COMMAND_CODE_PLAYER_UPDATE_LIST_METADATA), Integer.valueOf((int) COMMAND_CODE_PLAYER_SET_MEDIA_ITEM)));
        VERSION_PLAYER_PLAYLIST_COMMANDS_MAP.put(2, Collections.singletonList(Integer.valueOf((int) COMMAND_CODE_PLAYER_MOVE_PLAYLIST_ITEM)));
        SparseArray<List<Integer>> sparseArray = new SparseArray<>();
        VERSION_VOLUME_COMMANDS_MAP = sparseArray;
        sparseArray.put(1, Arrays.asList(30000, Integer.valueOf((int) COMMAND_CODE_VOLUME_ADJUST_VOLUME)));
        SparseArray<List<Integer>> sparseArray2 = new SparseArray<>();
        VERSION_SESSION_COMMANDS_MAP = sparseArray2;
        sparseArray2.put(1, Arrays.asList(Integer.valueOf((int) COMMAND_CODE_SESSION_FAST_FORWARD), 40001, 40002, 40003, Integer.valueOf((int) COMMAND_CODE_SESSION_SET_RATING)));
        VERSION_SESSION_COMMANDS_MAP.put(2, Collections.singletonList(Integer.valueOf((int) COMMAND_CODE_SESSION_SET_MEDIA_URI)));
        SparseArray<List<Integer>> sparseArray3 = new SparseArray<>();
        VERSION_LIBRARY_COMMANDS_MAP = sparseArray3;
        sparseArray3.put(1, Arrays.asList(50000, Integer.valueOf((int) COMMAND_CODE_LIBRARY_SUBSCRIBE), Integer.valueOf((int) COMMAND_CODE_LIBRARY_UNSUBSCRIBE), Integer.valueOf((int) COMMAND_CODE_LIBRARY_GET_CHILDREN), Integer.valueOf((int) COMMAND_CODE_LIBRARY_GET_ITEM), 50005, Integer.valueOf((int) COMMAND_CODE_LIBRARY_GET_SEARCH_RESULT)));
    }

    public SessionCommand() {
    }

    public int getCommandCode() {
        return this.mCommandCode;
    }

    @Nullable
    public String getCustomAction() {
        return this.mCustomAction;
    }

    @Nullable
    public Bundle getCustomExtras() {
        return this.mCustomExtras;
    }

    public int hashCode() {
        return ObjectsCompat.hash(this.mCustomAction, Integer.valueOf(this.mCommandCode));
    }

    public SessionCommand(int i) {
        if (i != 0) {
            this.mCommandCode = i;
            this.mCustomAction = null;
            this.mCustomExtras = null;
            return;
        }
        throw new IllegalArgumentException("commandCode shouldn't be COMMAND_CODE_CUSTOM");
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SessionCommand)) {
            return false;
        }
        SessionCommand sessionCommand = (SessionCommand) obj;
        if (this.mCommandCode != sessionCommand.mCommandCode || !TextUtils.equals(this.mCustomAction, sessionCommand.mCustomAction)) {
            return false;
        }
        return true;
    }

    public SessionCommand(@NonNull String str, @Nullable Bundle bundle) {
        if (str != null) {
            this.mCommandCode = 0;
            this.mCustomAction = str;
            this.mCustomExtras = bundle;
            return;
        }
        throw new NullPointerException("action shouldn't be null");
    }
}

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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class SessionCommand implements VersionedParcelable {
    public static /* synthetic */ Interceptable $ic = null;
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
    public static final SparseArray<List<Integer>> VERSION_PLAYER_BASIC_COMMANDS_MAP;
    public static final SparseArray<List<Integer>> VERSION_PLAYER_PLAYLIST_COMMANDS_MAP;
    public static final SparseArray<List<Integer>> VERSION_SESSION_COMMANDS_MAP;
    public static final SparseArray<List<Integer>> VERSION_VOLUME_COMMANDS_MAP;
    public transient /* synthetic */ FieldHolder $fh;
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
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-306072506, "Landroidx/media2/session/SessionCommand;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-306072506, "Landroidx/media2/session/SessionCommand;");
                return;
            }
        }
        VERSION_PLAYER_BASIC_COMMANDS_MAP = new SparseArray<>();
        VERSION_PLAYER_PLAYLIST_COMMANDS_MAP = new SparseArray<>();
        VERSION_PLAYER_BASIC_COMMANDS_MAP.put(1, Arrays.asList(10000, 10001, 10002, 10003, 10004, 11000, 11001, 11002));
        VERSION_PLAYER_PLAYLIST_COMMANDS_MAP.put(1, Arrays.asList(10005, 10006, 10007, 10008, 10009, 10010, 10011, 10012, 10013, 10014, 10015, Integer.valueOf((int) COMMAND_CODE_PLAYER_GET_CURRENT_MEDIA_ITEM), Integer.valueOf((int) COMMAND_CODE_PLAYER_UPDATE_LIST_METADATA), Integer.valueOf((int) COMMAND_CODE_PLAYER_SET_MEDIA_ITEM)));
        VERSION_PLAYER_PLAYLIST_COMMANDS_MAP.put(2, Collections.singletonList(Integer.valueOf((int) COMMAND_CODE_PLAYER_MOVE_PLAYLIST_ITEM)));
        SparseArray<List<Integer>> sparseArray = new SparseArray<>();
        VERSION_VOLUME_COMMANDS_MAP = sparseArray;
        sparseArray.put(1, Arrays.asList(30000, Integer.valueOf((int) COMMAND_CODE_VOLUME_ADJUST_VOLUME)));
        SparseArray<List<Integer>> sparseArray2 = new SparseArray<>();
        VERSION_SESSION_COMMANDS_MAP = sparseArray2;
        sparseArray2.put(1, Arrays.asList(Integer.valueOf((int) COMMAND_CODE_SESSION_FAST_FORWARD), Integer.valueOf((int) COMMAND_CODE_SESSION_REWIND), Integer.valueOf((int) COMMAND_CODE_SESSION_SKIP_FORWARD), Integer.valueOf((int) COMMAND_CODE_SESSION_SKIP_BACKWARD), Integer.valueOf((int) COMMAND_CODE_SESSION_SET_RATING)));
        VERSION_SESSION_COMMANDS_MAP.put(2, Collections.singletonList(Integer.valueOf((int) COMMAND_CODE_SESSION_SET_MEDIA_URI)));
        SparseArray<List<Integer>> sparseArray3 = new SparseArray<>();
        VERSION_LIBRARY_COMMANDS_MAP = sparseArray3;
        sparseArray3.put(1, Arrays.asList(50000, Integer.valueOf((int) COMMAND_CODE_LIBRARY_SUBSCRIBE), Integer.valueOf((int) COMMAND_CODE_LIBRARY_UNSUBSCRIBE), Integer.valueOf((int) COMMAND_CODE_LIBRARY_GET_CHILDREN), Integer.valueOf((int) COMMAND_CODE_LIBRARY_GET_ITEM), Integer.valueOf((int) COMMAND_CODE_LIBRARY_SEARCH), Integer.valueOf((int) COMMAND_CODE_LIBRARY_GET_SEARCH_RESULT)));
    }

    public SessionCommand() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public int getCommandCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mCommandCode;
        }
        return invokeV.intValue;
    }

    @Nullable
    public String getCustomAction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mCustomAction;
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public Bundle getCustomExtras() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mCustomExtras;
        }
        return (Bundle) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return ObjectsCompat.hash(this.mCustomAction, Integer.valueOf(this.mCommandCode));
        }
        return invokeV.intValue;
    }

    public SessionCommand(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        if (i != 0) {
            this.mCommandCode = i;
            this.mCustomAction = null;
            this.mCustomExtras = null;
            return;
        }
        throw new IllegalArgumentException("commandCode shouldn't be COMMAND_CODE_CUSTOM");
    }

    public SessionCommand(@NonNull String str, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, bundle};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        if (str != null) {
            this.mCommandCode = 0;
            this.mCustomAction = str;
            this.mCustomExtras = bundle;
            return;
        }
        throw new NullPointerException("action shouldn't be null");
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (!(obj instanceof SessionCommand)) {
                return false;
            }
            SessionCommand sessionCommand = (SessionCommand) obj;
            if (this.mCommandCode != sessionCommand.mCommandCode || !TextUtils.equals(this.mCustomAction, sessionCommand.mCustomAction)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}

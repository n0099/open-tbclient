package androidx.media2.session;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.versionedparcelable.VersionedParcelable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public final class SessionCommandGroup implements VersionedParcelable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "SessionCommandGroup";
    public transient /* synthetic */ FieldHolder $fh;
    public Set<SessionCommand> mCommands;

    /* loaded from: classes.dex */
    public static final class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Set<SessionCommand> mCommands;

        public Builder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mCommands = new HashSet();
        }

        @NonNull
        public SessionCommandGroup build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return new SessionCommandGroup(this.mCommands);
            }
            return (SessionCommandGroup) invokeV.objValue;
        }

        public Builder(@NonNull SessionCommandGroup sessionCommandGroup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sessionCommandGroup};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            if (sessionCommandGroup != null) {
                this.mCommands = sessionCommandGroup.getCommands();
                return;
            }
            throw new NullPointerException("commandGroup shouldn't be null");
        }

        @NonNull
        public Builder addAllPredefinedCommands(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
                if (i >= 1 && i <= 2) {
                    addAllPlayerCommands(i);
                    addAllVolumeCommands(i);
                    addAllSessionCommands(i);
                    addAllLibraryCommands(i);
                    return this;
                }
                throw new IllegalArgumentException("Unknown command version " + i);
            }
            return (Builder) invokeI.objValue;
        }

        private void addCommands(int i, SparseArray<List<Integer>> sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(65538, this, i, sparseArray) == null) {
                for (int i2 = 0; i2 < sparseArray.size() && sparseArray.keyAt(i2) <= i; i2++) {
                    for (Integer num : sparseArray.valueAt(i2)) {
                        addCommand(new SessionCommand(num.intValue()));
                    }
                }
            }
        }

        @NonNull
        public Builder addAllLibraryCommands(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                addCommands(i, SessionCommand.VERSION_LIBRARY_COMMANDS_MAP);
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        @NonNull
        public Builder addAllPlayerBasicCommands(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                addCommands(i, SessionCommand.VERSION_PLAYER_BASIC_COMMANDS_MAP);
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        @NonNull
        public Builder addAllPlayerCommands(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                addAllPlayerBasicCommands(i);
                addAllPlayerPlaylistCommands(i);
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        @NonNull
        public Builder addAllPlayerPlaylistCommands(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
                addCommands(i, SessionCommand.VERSION_PLAYER_PLAYLIST_COMMANDS_MAP);
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        @NonNull
        public Builder addAllSessionCommands(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
                addCommands(i, SessionCommand.VERSION_SESSION_COMMANDS_MAP);
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        @NonNull
        public Builder addAllVolumeCommands(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
                addCommands(i, SessionCommand.VERSION_VOLUME_COMMANDS_MAP);
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        @NonNull
        public Builder addCommand(@NonNull SessionCommand sessionCommand) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, sessionCommand)) == null) {
                if (sessionCommand != null) {
                    this.mCommands.add(sessionCommand);
                    return this;
                }
                throw new NullPointerException("command shouldn't be null");
            }
            return (Builder) invokeL.objValue;
        }

        @NonNull
        public Builder removeCommand(@NonNull SessionCommand sessionCommand) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, sessionCommand)) == null) {
                if (sessionCommand != null) {
                    this.mCommands.remove(sessionCommand);
                    return this;
                }
                throw new NullPointerException("command shouldn't be null");
            }
            return (Builder) invokeL.objValue;
        }
    }

    public SessionCommandGroup() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mCommands = new HashSet();
    }

    @NonNull
    public Set<SessionCommand> getCommands() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return new HashSet(this.mCommands);
        }
        return (Set) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return ObjectsCompat.hashCode(this.mCommands);
        }
        return invokeV.intValue;
    }

    public SessionCommandGroup(@Nullable Collection<SessionCommand> collection) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {collection};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        HashSet hashSet = new HashSet();
        this.mCommands = hashSet;
        if (collection != null) {
            hashSet.addAll(collection);
        }
    }

    public boolean hasCommand(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            if (i != 0) {
                for (SessionCommand sessionCommand : this.mCommands) {
                    if (sessionCommand.getCommandCode() == i) {
                        return true;
                    }
                }
                return false;
            }
            throw new IllegalArgumentException("Use hasCommand(Command) for custom command");
        }
        return invokeI.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SessionCommandGroup)) {
                return false;
            }
            SessionCommandGroup sessionCommandGroup = (SessionCommandGroup) obj;
            Set<SessionCommand> set = this.mCommands;
            if (set == null) {
                if (sessionCommandGroup.mCommands == null) {
                    return true;
                }
                return false;
            }
            return set.equals(sessionCommandGroup.mCommands);
        }
        return invokeL.booleanValue;
    }

    public boolean hasCommand(@NonNull SessionCommand sessionCommand) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, sessionCommand)) == null) {
            if (sessionCommand != null) {
                return this.mCommands.contains(sessionCommand);
            }
            throw new NullPointerException("command shouldn't be null");
        }
        return invokeL.booleanValue;
    }
}

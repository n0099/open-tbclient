package androidx.media2.session;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.view.Surface;
import androidx.core.view.InputDeviceCompat;
import androidx.media2.session.IMediaController;
import androidx.versionedparcelable.ParcelImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes.dex */
public interface IMediaSession extends IInterface {

    /* loaded from: classes.dex */
    public static class Default implements IMediaSession {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Default() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // androidx.media2.session.IMediaSession
        public void addPlaylistItem(IMediaController iMediaController, int i, int i2, String str) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{iMediaController, Integer.valueOf(i), Integer.valueOf(i2), str}) == null) {
            }
        }

        @Override // androidx.media2.session.IMediaSession
        public void adjustVolume(IMediaController iMediaController, int i, int i2, int i3) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iMediaController, i, i2, i3) == null) {
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (IBinder) invokeV.objValue;
        }

        @Override // androidx.media2.session.IMediaSession
        public void connect(IMediaController iMediaController, int i, ParcelImpl parcelImpl) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048579, this, iMediaController, i, parcelImpl) == null) {
            }
        }

        @Override // androidx.media2.session.IMediaSession
        public void deselectTrack(IMediaController iMediaController, int i, ParcelImpl parcelImpl) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048580, this, iMediaController, i, parcelImpl) == null) {
            }
        }

        @Override // androidx.media2.session.IMediaSession
        public void fastForward(IMediaController iMediaController, int i) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048581, this, iMediaController, i) == null) {
            }
        }

        @Override // androidx.media2.session.IMediaSession
        public void getChildren(IMediaController iMediaController, int i, String str, int i2, int i3, ParcelImpl parcelImpl) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{iMediaController, Integer.valueOf(i), str, Integer.valueOf(i2), Integer.valueOf(i3), parcelImpl}) == null) {
            }
        }

        @Override // androidx.media2.session.IMediaSession
        public void getItem(IMediaController iMediaController, int i, String str) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048583, this, iMediaController, i, str) == null) {
            }
        }

        @Override // androidx.media2.session.IMediaSession
        public void getLibraryRoot(IMediaController iMediaController, int i, ParcelImpl parcelImpl) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, iMediaController, i, parcelImpl) == null) {
            }
        }

        @Override // androidx.media2.session.IMediaSession
        public void getSearchResult(IMediaController iMediaController, int i, String str, int i2, int i3, ParcelImpl parcelImpl) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{iMediaController, Integer.valueOf(i), str, Integer.valueOf(i2), Integer.valueOf(i3), parcelImpl}) == null) {
            }
        }

        @Override // androidx.media2.session.IMediaSession
        public void movePlaylistItem(IMediaController iMediaController, int i, int i2, int i3) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048586, this, iMediaController, i, i2, i3) == null) {
            }
        }

        @Override // androidx.media2.session.IMediaSession
        public void onControllerResult(IMediaController iMediaController, int i, ParcelImpl parcelImpl) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048587, this, iMediaController, i, parcelImpl) == null) {
            }
        }

        @Override // androidx.media2.session.IMediaSession
        public void onCustomCommand(IMediaController iMediaController, int i, ParcelImpl parcelImpl, Bundle bundle) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048588, this, iMediaController, i, parcelImpl, bundle) == null) {
            }
        }

        @Override // androidx.media2.session.IMediaSession
        public void pause(IMediaController iMediaController, int i) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048589, this, iMediaController, i) == null) {
            }
        }

        @Override // androidx.media2.session.IMediaSession
        public void play(IMediaController iMediaController, int i) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048590, this, iMediaController, i) == null) {
            }
        }

        @Override // androidx.media2.session.IMediaSession
        public void prepare(IMediaController iMediaController, int i) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048591, this, iMediaController, i) == null) {
            }
        }

        @Override // androidx.media2.session.IMediaSession
        public void release(IMediaController iMediaController, int i) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048592, this, iMediaController, i) == null) {
            }
        }

        @Override // androidx.media2.session.IMediaSession
        public void removePlaylistItem(IMediaController iMediaController, int i, int i2) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048593, this, iMediaController, i, i2) == null) {
            }
        }

        @Override // androidx.media2.session.IMediaSession
        public void replacePlaylistItem(IMediaController iMediaController, int i, int i2, String str) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{iMediaController, Integer.valueOf(i), Integer.valueOf(i2), str}) == null) {
            }
        }

        @Override // androidx.media2.session.IMediaSession
        public void rewind(IMediaController iMediaController, int i) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048595, this, iMediaController, i) == null) {
            }
        }

        @Override // androidx.media2.session.IMediaSession
        public void search(IMediaController iMediaController, int i, String str, ParcelImpl parcelImpl) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048596, this, iMediaController, i, str, parcelImpl) == null) {
            }
        }

        @Override // androidx.media2.session.IMediaSession
        public void seekTo(IMediaController iMediaController, int i, long j) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{iMediaController, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            }
        }

        @Override // androidx.media2.session.IMediaSession
        public void selectTrack(IMediaController iMediaController, int i, ParcelImpl parcelImpl) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048598, this, iMediaController, i, parcelImpl) == null) {
            }
        }

        @Override // androidx.media2.session.IMediaSession
        public void setMediaItem(IMediaController iMediaController, int i, String str) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048599, this, iMediaController, i, str) == null) {
            }
        }

        @Override // androidx.media2.session.IMediaSession
        public void setMediaUri(IMediaController iMediaController, int i, Uri uri, Bundle bundle) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048600, this, iMediaController, i, uri, bundle) == null) {
            }
        }

        @Override // androidx.media2.session.IMediaSession
        public void setPlaybackSpeed(IMediaController iMediaController, int i, float f) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{iMediaController, Integer.valueOf(i), Float.valueOf(f)}) == null) {
            }
        }

        @Override // androidx.media2.session.IMediaSession
        public void setPlaylist(IMediaController iMediaController, int i, List<String> list, ParcelImpl parcelImpl) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048602, this, iMediaController, i, list, parcelImpl) == null) {
            }
        }

        @Override // androidx.media2.session.IMediaSession
        public void setRating(IMediaController iMediaController, int i, String str, ParcelImpl parcelImpl) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048603, this, iMediaController, i, str, parcelImpl) == null) {
            }
        }

        @Override // androidx.media2.session.IMediaSession
        public void setRepeatMode(IMediaController iMediaController, int i, int i2) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048604, this, iMediaController, i, i2) == null) {
            }
        }

        @Override // androidx.media2.session.IMediaSession
        public void setShuffleMode(IMediaController iMediaController, int i, int i2) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048605, this, iMediaController, i, i2) == null) {
            }
        }

        @Override // androidx.media2.session.IMediaSession
        public void setSurface(IMediaController iMediaController, int i, Surface surface) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048606, this, iMediaController, i, surface) == null) {
            }
        }

        @Override // androidx.media2.session.IMediaSession
        public void setVolumeTo(IMediaController iMediaController, int i, int i2, int i3) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048607, this, iMediaController, i, i2, i3) == null) {
            }
        }

        @Override // androidx.media2.session.IMediaSession
        public void skipBackward(IMediaController iMediaController, int i) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048608, this, iMediaController, i) == null) {
            }
        }

        @Override // androidx.media2.session.IMediaSession
        public void skipForward(IMediaController iMediaController, int i) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048609, this, iMediaController, i) == null) {
            }
        }

        @Override // androidx.media2.session.IMediaSession
        public void skipToNextItem(IMediaController iMediaController, int i) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048610, this, iMediaController, i) == null) {
            }
        }

        @Override // androidx.media2.session.IMediaSession
        public void skipToPlaylistItem(IMediaController iMediaController, int i, int i2) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048611, this, iMediaController, i, i2) == null) {
            }
        }

        @Override // androidx.media2.session.IMediaSession
        public void skipToPreviousItem(IMediaController iMediaController, int i) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048612, this, iMediaController, i) == null) {
            }
        }

        @Override // androidx.media2.session.IMediaSession
        public void subscribe(IMediaController iMediaController, int i, String str, ParcelImpl parcelImpl) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048613, this, iMediaController, i, str, parcelImpl) == null) {
            }
        }

        @Override // androidx.media2.session.IMediaSession
        public void unsubscribe(IMediaController iMediaController, int i, String str) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048614, this, iMediaController, i, str) == null) {
            }
        }

        @Override // androidx.media2.session.IMediaSession
        public void updatePlaylistMetadata(IMediaController iMediaController, int i, ParcelImpl parcelImpl) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048615, this, iMediaController, i, parcelImpl) == null) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IMediaSession {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String DESCRIPTOR = "androidx.media2.session.IMediaSession";
        public static final int TRANSACTION_addPlaylistItem = 25;
        public static final int TRANSACTION_adjustVolume = 4;
        public static final int TRANSACTION_connect = 1;
        public static final int TRANSACTION_deselectTrack = 43;
        public static final int TRANSACTION_fastForward = 8;
        public static final int TRANSACTION_getChildren = 36;
        public static final int TRANSACTION_getItem = 35;
        public static final int TRANSACTION_getLibraryRoot = 34;
        public static final int TRANSACTION_getSearchResult = 38;
        public static final int TRANSACTION_movePlaylistItem = 44;
        public static final int TRANSACTION_onControllerResult = 33;
        public static final int TRANSACTION_onCustomCommand = 13;
        public static final int TRANSACTION_pause = 6;
        public static final int TRANSACTION_play = 5;
        public static final int TRANSACTION_prepare = 7;
        public static final int TRANSACTION_release = 2;
        public static final int TRANSACTION_removePlaylistItem = 26;
        public static final int TRANSACTION_replacePlaylistItem = 27;
        public static final int TRANSACTION_rewind = 9;
        public static final int TRANSACTION_search = 37;
        public static final int TRANSACTION_seekTo = 12;
        public static final int TRANSACTION_selectTrack = 42;
        public static final int TRANSACTION_setMediaItem = 23;
        public static final int TRANSACTION_setMediaUri = 45;
        public static final int TRANSACTION_setPlaybackSpeed = 21;
        public static final int TRANSACTION_setPlaylist = 22;
        public static final int TRANSACTION_setRating = 20;
        public static final int TRANSACTION_setRepeatMode = 31;
        public static final int TRANSACTION_setShuffleMode = 32;
        public static final int TRANSACTION_setSurface = 41;
        public static final int TRANSACTION_setVolumeTo = 3;
        public static final int TRANSACTION_skipBackward = 11;
        public static final int TRANSACTION_skipForward = 10;
        public static final int TRANSACTION_skipToNextItem = 30;
        public static final int TRANSACTION_skipToPlaylistItem = 28;
        public static final int TRANSACTION_skipToPreviousItem = 29;
        public static final int TRANSACTION_subscribe = 39;
        public static final int TRANSACTION_unsubscribe = 40;
        public static final int TRANSACTION_updatePlaylistMetadata = 24;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes.dex */
        public static class Proxy implements IMediaSession {
            public static /* synthetic */ Interceptable $ic;
            public static IMediaSession sDefaultImpl;
            public transient /* synthetic */ FieldHolder $fh;
            public IBinder mRemote;

            public Proxy(IBinder iBinder) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iBinder};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.mRemote = iBinder;
            }

            @Override // androidx.media2.session.IMediaSession
            public void addPlaylistItem(IMediaController iMediaController, int i, int i2, String str) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{iMediaController, Integer.valueOf(i), Integer.valueOf(i2), str}) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                        obtain.writeInt(i);
                        obtain.writeInt(i2);
                        obtain.writeString(str);
                        if (this.mRemote.transact(25, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                            return;
                        }
                        Stub.getDefaultImpl().addPlaylistItem(iMediaController, i, i2, str);
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void adjustVolume(IMediaController iMediaController, int i, int i2, int i3) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iMediaController, i, i2, i3) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                        obtain.writeInt(i);
                        obtain.writeInt(i2);
                        obtain.writeInt(i3);
                        if (this.mRemote.transact(4, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                            return;
                        }
                        Stub.getDefaultImpl().adjustVolume(iMediaController, i, i2, i3);
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mRemote : (IBinder) invokeV.objValue;
            }

            @Override // androidx.media2.session.IMediaSession
            public void connect(IMediaController iMediaController, int i, ParcelImpl parcelImpl) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLIL(1048579, this, iMediaController, i, parcelImpl) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                        obtain.writeInt(i);
                        if (parcelImpl != null) {
                            obtain.writeInt(1);
                            parcelImpl.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        if (this.mRemote.transact(1, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                            return;
                        }
                        Stub.getDefaultImpl().connect(iMediaController, i, parcelImpl);
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void deselectTrack(IMediaController iMediaController, int i, ParcelImpl parcelImpl) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLIL(1048580, this, iMediaController, i, parcelImpl) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                        obtain.writeInt(i);
                        if (parcelImpl != null) {
                            obtain.writeInt(1);
                            parcelImpl.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        if (this.mRemote.transact(43, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                            return;
                        }
                        Stub.getDefaultImpl().deselectTrack(iMediaController, i, parcelImpl);
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void fastForward(IMediaController iMediaController, int i) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048581, this, iMediaController, i) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                        obtain.writeInt(i);
                        if (this.mRemote.transact(8, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                            return;
                        }
                        Stub.getDefaultImpl().fastForward(iMediaController, i);
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void getChildren(IMediaController iMediaController, int i, String str, int i2, int i3, ParcelImpl parcelImpl) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{iMediaController, Integer.valueOf(i), str, Integer.valueOf(i2), Integer.valueOf(i3), parcelImpl}) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                        obtain.writeInt(i);
                        obtain.writeString(str);
                        obtain.writeInt(i2);
                        obtain.writeInt(i3);
                        if (parcelImpl != null) {
                            obtain.writeInt(1);
                            parcelImpl.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        if (this.mRemote.transact(36, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                            return;
                        }
                        Stub.getDefaultImpl().getChildren(iMediaController, i, str, i2, i3, parcelImpl);
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            public String getInterfaceDescriptor() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? Stub.DESCRIPTOR : (String) invokeV.objValue;
            }

            @Override // androidx.media2.session.IMediaSession
            public void getItem(IMediaController iMediaController, int i, String str) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, iMediaController, i, str) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                        obtain.writeInt(i);
                        obtain.writeString(str);
                        if (this.mRemote.transact(35, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                            return;
                        }
                        Stub.getDefaultImpl().getItem(iMediaController, i, str);
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void getLibraryRoot(IMediaController iMediaController, int i, ParcelImpl parcelImpl) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLIL(1048585, this, iMediaController, i, parcelImpl) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                        obtain.writeInt(i);
                        if (parcelImpl != null) {
                            obtain.writeInt(1);
                            parcelImpl.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        if (this.mRemote.transact(34, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                            return;
                        }
                        Stub.getDefaultImpl().getLibraryRoot(iMediaController, i, parcelImpl);
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void getSearchResult(IMediaController iMediaController, int i, String str, int i2, int i3, ParcelImpl parcelImpl) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{iMediaController, Integer.valueOf(i), str, Integer.valueOf(i2), Integer.valueOf(i3), parcelImpl}) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                        obtain.writeInt(i);
                        obtain.writeString(str);
                        obtain.writeInt(i2);
                        obtain.writeInt(i3);
                        if (parcelImpl != null) {
                            obtain.writeInt(1);
                            parcelImpl.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        if (this.mRemote.transact(38, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                            return;
                        }
                        Stub.getDefaultImpl().getSearchResult(iMediaController, i, str, i2, i3, parcelImpl);
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void movePlaylistItem(IMediaController iMediaController, int i, int i2, int i3) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLIII(1048587, this, iMediaController, i, i2, i3) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                        obtain.writeInt(i);
                        obtain.writeInt(i2);
                        obtain.writeInt(i3);
                        if (this.mRemote.transact(44, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                            return;
                        }
                        Stub.getDefaultImpl().movePlaylistItem(iMediaController, i, i2, i3);
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void onControllerResult(IMediaController iMediaController, int i, ParcelImpl parcelImpl) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLIL(1048588, this, iMediaController, i, parcelImpl) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                        obtain.writeInt(i);
                        if (parcelImpl != null) {
                            obtain.writeInt(1);
                            parcelImpl.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        if (this.mRemote.transact(33, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                            return;
                        }
                        Stub.getDefaultImpl().onControllerResult(iMediaController, i, parcelImpl);
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void onCustomCommand(IMediaController iMediaController, int i, ParcelImpl parcelImpl, Bundle bundle) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLILL(1048589, this, iMediaController, i, parcelImpl, bundle) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                        obtain.writeInt(i);
                        if (parcelImpl != null) {
                            obtain.writeInt(1);
                            parcelImpl.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        if (bundle != null) {
                            obtain.writeInt(1);
                            bundle.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        if (this.mRemote.transact(13, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                            return;
                        }
                        Stub.getDefaultImpl().onCustomCommand(iMediaController, i, parcelImpl, bundle);
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void pause(IMediaController iMediaController, int i) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048590, this, iMediaController, i) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                        obtain.writeInt(i);
                        if (this.mRemote.transact(6, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                            return;
                        }
                        Stub.getDefaultImpl().pause(iMediaController, i);
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void play(IMediaController iMediaController, int i) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048591, this, iMediaController, i) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                        obtain.writeInt(i);
                        if (this.mRemote.transact(5, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                            return;
                        }
                        Stub.getDefaultImpl().play(iMediaController, i);
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void prepare(IMediaController iMediaController, int i) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048592, this, iMediaController, i) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                        obtain.writeInt(i);
                        if (this.mRemote.transact(7, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                            return;
                        }
                        Stub.getDefaultImpl().prepare(iMediaController, i);
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void release(IMediaController iMediaController, int i) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048593, this, iMediaController, i) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                        obtain.writeInt(i);
                        if (this.mRemote.transact(2, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                            return;
                        }
                        Stub.getDefaultImpl().release(iMediaController, i);
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void removePlaylistItem(IMediaController iMediaController, int i, int i2) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLII(1048594, this, iMediaController, i, i2) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                        obtain.writeInt(i);
                        obtain.writeInt(i2);
                        if (this.mRemote.transact(26, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                            return;
                        }
                        Stub.getDefaultImpl().removePlaylistItem(iMediaController, i, i2);
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void replacePlaylistItem(IMediaController iMediaController, int i, int i2, String str) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{iMediaController, Integer.valueOf(i), Integer.valueOf(i2), str}) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                        obtain.writeInt(i);
                        obtain.writeInt(i2);
                        obtain.writeString(str);
                        if (this.mRemote.transact(27, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                            return;
                        }
                        Stub.getDefaultImpl().replacePlaylistItem(iMediaController, i, i2, str);
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void rewind(IMediaController iMediaController, int i) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048596, this, iMediaController, i) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                        obtain.writeInt(i);
                        if (this.mRemote.transact(9, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                            return;
                        }
                        Stub.getDefaultImpl().rewind(iMediaController, i);
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void search(IMediaController iMediaController, int i, String str, ParcelImpl parcelImpl) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLILL(1048597, this, iMediaController, i, str, parcelImpl) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                        obtain.writeInt(i);
                        obtain.writeString(str);
                        if (parcelImpl != null) {
                            obtain.writeInt(1);
                            parcelImpl.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        if (this.mRemote.transact(37, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                            return;
                        }
                        Stub.getDefaultImpl().search(iMediaController, i, str, parcelImpl);
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void seekTo(IMediaController iMediaController, int i, long j) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{iMediaController, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                        obtain.writeInt(i);
                        obtain.writeLong(j);
                        if (this.mRemote.transact(12, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                            return;
                        }
                        Stub.getDefaultImpl().seekTo(iMediaController, i, j);
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void selectTrack(IMediaController iMediaController, int i, ParcelImpl parcelImpl) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLIL(1048599, this, iMediaController, i, parcelImpl) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                        obtain.writeInt(i);
                        if (parcelImpl != null) {
                            obtain.writeInt(1);
                            parcelImpl.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        if (this.mRemote.transact(42, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                            return;
                        }
                        Stub.getDefaultImpl().selectTrack(iMediaController, i, parcelImpl);
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void setMediaItem(IMediaController iMediaController, int i, String str) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLIL(1048600, this, iMediaController, i, str) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                        obtain.writeInt(i);
                        obtain.writeString(str);
                        if (this.mRemote.transact(23, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                            return;
                        }
                        Stub.getDefaultImpl().setMediaItem(iMediaController, i, str);
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void setMediaUri(IMediaController iMediaController, int i, Uri uri, Bundle bundle) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLILL(1048601, this, iMediaController, i, uri, bundle) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                        obtain.writeInt(i);
                        if (uri != null) {
                            obtain.writeInt(1);
                            uri.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        if (bundle != null) {
                            obtain.writeInt(1);
                            bundle.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        if (this.mRemote.transact(45, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                            return;
                        }
                        Stub.getDefaultImpl().setMediaUri(iMediaController, i, uri, bundle);
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void setPlaybackSpeed(IMediaController iMediaController, int i, float f) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{iMediaController, Integer.valueOf(i), Float.valueOf(f)}) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                        obtain.writeInt(i);
                        obtain.writeFloat(f);
                        if (this.mRemote.transact(21, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                            return;
                        }
                        Stub.getDefaultImpl().setPlaybackSpeed(iMediaController, i, f);
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void setPlaylist(IMediaController iMediaController, int i, List<String> list, ParcelImpl parcelImpl) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLILL(1048603, this, iMediaController, i, list, parcelImpl) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                        obtain.writeInt(i);
                        obtain.writeStringList(list);
                        if (parcelImpl != null) {
                            obtain.writeInt(1);
                            parcelImpl.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        if (this.mRemote.transact(22, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                            return;
                        }
                        Stub.getDefaultImpl().setPlaylist(iMediaController, i, list, parcelImpl);
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void setRating(IMediaController iMediaController, int i, String str, ParcelImpl parcelImpl) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLILL(1048604, this, iMediaController, i, str, parcelImpl) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                        obtain.writeInt(i);
                        obtain.writeString(str);
                        if (parcelImpl != null) {
                            obtain.writeInt(1);
                            parcelImpl.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        if (this.mRemote.transact(20, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                            return;
                        }
                        Stub.getDefaultImpl().setRating(iMediaController, i, str, parcelImpl);
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void setRepeatMode(IMediaController iMediaController, int i, int i2) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLII(1048605, this, iMediaController, i, i2) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                        obtain.writeInt(i);
                        obtain.writeInt(i2);
                        if (this.mRemote.transact(31, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                            return;
                        }
                        Stub.getDefaultImpl().setRepeatMode(iMediaController, i, i2);
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void setShuffleMode(IMediaController iMediaController, int i, int i2) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLII(1048606, this, iMediaController, i, i2) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                        obtain.writeInt(i);
                        obtain.writeInt(i2);
                        if (this.mRemote.transact(32, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                            return;
                        }
                        Stub.getDefaultImpl().setShuffleMode(iMediaController, i, i2);
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void setSurface(IMediaController iMediaController, int i, Surface surface) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLIL(1048607, this, iMediaController, i, surface) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                        obtain.writeInt(i);
                        if (surface != null) {
                            obtain.writeInt(1);
                            surface.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        if (this.mRemote.transact(41, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                            return;
                        }
                        Stub.getDefaultImpl().setSurface(iMediaController, i, surface);
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void setVolumeTo(IMediaController iMediaController, int i, int i2, int i3) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLIII(1048608, this, iMediaController, i, i2, i3) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                        obtain.writeInt(i);
                        obtain.writeInt(i2);
                        obtain.writeInt(i3);
                        if (this.mRemote.transact(3, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                            return;
                        }
                        Stub.getDefaultImpl().setVolumeTo(iMediaController, i, i2, i3);
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void skipBackward(IMediaController iMediaController, int i) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048609, this, iMediaController, i) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                        obtain.writeInt(i);
                        if (this.mRemote.transact(11, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                            return;
                        }
                        Stub.getDefaultImpl().skipBackward(iMediaController, i);
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void skipForward(IMediaController iMediaController, int i) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048610, this, iMediaController, i) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                        obtain.writeInt(i);
                        if (this.mRemote.transact(10, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                            return;
                        }
                        Stub.getDefaultImpl().skipForward(iMediaController, i);
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void skipToNextItem(IMediaController iMediaController, int i) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048611, this, iMediaController, i) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                        obtain.writeInt(i);
                        if (this.mRemote.transact(30, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                            return;
                        }
                        Stub.getDefaultImpl().skipToNextItem(iMediaController, i);
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void skipToPlaylistItem(IMediaController iMediaController, int i, int i2) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLII(1048612, this, iMediaController, i, i2) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                        obtain.writeInt(i);
                        obtain.writeInt(i2);
                        if (this.mRemote.transact(28, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                            return;
                        }
                        Stub.getDefaultImpl().skipToPlaylistItem(iMediaController, i, i2);
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void skipToPreviousItem(IMediaController iMediaController, int i) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(1048613, this, iMediaController, i) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                        obtain.writeInt(i);
                        if (this.mRemote.transact(29, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                            return;
                        }
                        Stub.getDefaultImpl().skipToPreviousItem(iMediaController, i);
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void subscribe(IMediaController iMediaController, int i, String str, ParcelImpl parcelImpl) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLILL(1048614, this, iMediaController, i, str, parcelImpl) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                        obtain.writeInt(i);
                        obtain.writeString(str);
                        if (parcelImpl != null) {
                            obtain.writeInt(1);
                            parcelImpl.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        if (this.mRemote.transact(39, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                            return;
                        }
                        Stub.getDefaultImpl().subscribe(iMediaController, i, str, parcelImpl);
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void unsubscribe(IMediaController iMediaController, int i, String str) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLIL(1048615, this, iMediaController, i, str) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                        obtain.writeInt(i);
                        obtain.writeString(str);
                        if (this.mRemote.transact(40, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                            return;
                        }
                        Stub.getDefaultImpl().unsubscribe(iMediaController, i, str);
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // androidx.media2.session.IMediaSession
            public void updatePlaylistMetadata(IMediaController iMediaController, int i, ParcelImpl parcelImpl) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLIL(1048616, this, iMediaController, i, parcelImpl) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeStrongBinder(iMediaController != null ? iMediaController.asBinder() : null);
                        obtain.writeInt(i);
                        if (parcelImpl != null) {
                            obtain.writeInt(1);
                            parcelImpl.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        if (this.mRemote.transact(24, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                            return;
                        }
                        Stub.getDefaultImpl().updatePlaylistMetadata(iMediaController, i, parcelImpl);
                    } finally {
                        obtain.recycle();
                    }
                }
            }
        }

        public Stub() {
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
            attachInterface(this, DESCRIPTOR);
        }

        public static IMediaSession asInterface(IBinder iBinder) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, iBinder)) == null) {
                if (iBinder == null) {
                    return null;
                }
                IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
                if (queryLocalInterface != null && (queryLocalInterface instanceof IMediaSession)) {
                    return (IMediaSession) queryLocalInterface;
                }
                return new Proxy(iBinder);
            }
            return (IMediaSession) invokeL.objValue;
        }

        public static IMediaSession getDefaultImpl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? Proxy.sDefaultImpl : (IMediaSession) invokeV.objValue;
        }

        public static boolean setDefaultImpl(IMediaSession iMediaSession) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, iMediaSession)) == null) {
                if (Proxy.sDefaultImpl != null || iMediaSession == null) {
                    return false;
                }
                Proxy.sDefaultImpl = iMediaSession;
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this : (IBinder) invokeV.objValue;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), parcel, parcel2, Integer.valueOf(i2)})) == null) {
                if (i != 1598968902) {
                    switch (i) {
                        case 1:
                            parcel.enforceInterface(DESCRIPTOR);
                            connect(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0 ? ParcelImpl.CREATOR.createFromParcel(parcel) : null);
                            return true;
                        case 2:
                            parcel.enforceInterface(DESCRIPTOR);
                            release(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                            return true;
                        case 3:
                            parcel.enforceInterface(DESCRIPTOR);
                            setVolumeTo(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), parcel.readInt());
                            return true;
                        case 4:
                            parcel.enforceInterface(DESCRIPTOR);
                            adjustVolume(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), parcel.readInt());
                            return true;
                        case 5:
                            parcel.enforceInterface(DESCRIPTOR);
                            play(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                            return true;
                        case 6:
                            parcel.enforceInterface(DESCRIPTOR);
                            pause(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                            return true;
                        case 7:
                            parcel.enforceInterface(DESCRIPTOR);
                            prepare(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                            return true;
                        case 8:
                            parcel.enforceInterface(DESCRIPTOR);
                            fastForward(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                            return true;
                        case 9:
                            parcel.enforceInterface(DESCRIPTOR);
                            rewind(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                            return true;
                        case 10:
                            parcel.enforceInterface(DESCRIPTOR);
                            skipForward(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                            return true;
                        case 11:
                            parcel.enforceInterface(DESCRIPTOR);
                            skipBackward(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                            return true;
                        case 12:
                            parcel.enforceInterface(DESCRIPTOR);
                            seekTo(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readLong());
                            return true;
                        case 13:
                            parcel.enforceInterface(DESCRIPTOR);
                            onCustomCommand(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0 ? ParcelImpl.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                            return true;
                        default:
                            switch (i) {
                                case 20:
                                    parcel.enforceInterface(DESCRIPTOR);
                                    setRating(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.readInt() != 0 ? ParcelImpl.CREATOR.createFromParcel(parcel) : null);
                                    return true;
                                case 21:
                                    parcel.enforceInterface(DESCRIPTOR);
                                    setPlaybackSpeed(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readFloat());
                                    return true;
                                case 22:
                                    parcel.enforceInterface(DESCRIPTOR);
                                    setPlaylist(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.createStringArrayList(), parcel.readInt() != 0 ? ParcelImpl.CREATOR.createFromParcel(parcel) : null);
                                    return true;
                                case 23:
                                    parcel.enforceInterface(DESCRIPTOR);
                                    setMediaItem(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                                    return true;
                                case 24:
                                    parcel.enforceInterface(DESCRIPTOR);
                                    updatePlaylistMetadata(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0 ? ParcelImpl.CREATOR.createFromParcel(parcel) : null);
                                    return true;
                                case 25:
                                    parcel.enforceInterface(DESCRIPTOR);
                                    addPlaylistItem(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), parcel.readString());
                                    return true;
                                case 26:
                                    parcel.enforceInterface(DESCRIPTOR);
                                    removePlaylistItem(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt());
                                    return true;
                                case 27:
                                    parcel.enforceInterface(DESCRIPTOR);
                                    replacePlaylistItem(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), parcel.readString());
                                    return true;
                                case 28:
                                    parcel.enforceInterface(DESCRIPTOR);
                                    skipToPlaylistItem(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt());
                                    return true;
                                case 29:
                                    parcel.enforceInterface(DESCRIPTOR);
                                    skipToPreviousItem(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                                    return true;
                                case 30:
                                    parcel.enforceInterface(DESCRIPTOR);
                                    skipToNextItem(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                                    return true;
                                case 31:
                                    parcel.enforceInterface(DESCRIPTOR);
                                    setRepeatMode(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt());
                                    return true;
                                case 32:
                                    parcel.enforceInterface(DESCRIPTOR);
                                    setShuffleMode(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt());
                                    return true;
                                case 33:
                                    parcel.enforceInterface(DESCRIPTOR);
                                    onControllerResult(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0 ? ParcelImpl.CREATOR.createFromParcel(parcel) : null);
                                    return true;
                                case 34:
                                    parcel.enforceInterface(DESCRIPTOR);
                                    getLibraryRoot(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0 ? ParcelImpl.CREATOR.createFromParcel(parcel) : null);
                                    return true;
                                case 35:
                                    parcel.enforceInterface(DESCRIPTOR);
                                    getItem(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                                    return true;
                                case 36:
                                    parcel.enforceInterface(DESCRIPTOR);
                                    getChildren(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0 ? ParcelImpl.CREATOR.createFromParcel(parcel) : null);
                                    return true;
                                case 37:
                                    parcel.enforceInterface(DESCRIPTOR);
                                    search(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.readInt() != 0 ? ParcelImpl.CREATOR.createFromParcel(parcel) : null);
                                    return true;
                                case 38:
                                    parcel.enforceInterface(DESCRIPTOR);
                                    getSearchResult(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0 ? ParcelImpl.CREATOR.createFromParcel(parcel) : null);
                                    return true;
                                case 39:
                                    parcel.enforceInterface(DESCRIPTOR);
                                    subscribe(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.readInt() != 0 ? ParcelImpl.CREATOR.createFromParcel(parcel) : null);
                                    return true;
                                case 40:
                                    parcel.enforceInterface(DESCRIPTOR);
                                    unsubscribe(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                                    return true;
                                case 41:
                                    parcel.enforceInterface(DESCRIPTOR);
                                    setSurface(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0 ? (Surface) Surface.CREATOR.createFromParcel(parcel) : null);
                                    return true;
                                case 42:
                                    parcel.enforceInterface(DESCRIPTOR);
                                    selectTrack(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0 ? ParcelImpl.CREATOR.createFromParcel(parcel) : null);
                                    return true;
                                case 43:
                                    parcel.enforceInterface(DESCRIPTOR);
                                    deselectTrack(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0 ? ParcelImpl.CREATOR.createFromParcel(parcel) : null);
                                    return true;
                                case 44:
                                    parcel.enforceInterface(DESCRIPTOR);
                                    movePlaylistItem(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), parcel.readInt());
                                    return true;
                                case 45:
                                    parcel.enforceInterface(DESCRIPTOR);
                                    setMediaUri(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                                    return true;
                                default:
                                    return super.onTransact(i, parcel, parcel2, i2);
                            }
                    }
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            return invokeCommon.booleanValue;
        }
    }

    void addPlaylistItem(IMediaController iMediaController, int i, int i2, String str) throws RemoteException;

    void adjustVolume(IMediaController iMediaController, int i, int i2, int i3) throws RemoteException;

    void connect(IMediaController iMediaController, int i, ParcelImpl parcelImpl) throws RemoteException;

    void deselectTrack(IMediaController iMediaController, int i, ParcelImpl parcelImpl) throws RemoteException;

    void fastForward(IMediaController iMediaController, int i) throws RemoteException;

    void getChildren(IMediaController iMediaController, int i, String str, int i2, int i3, ParcelImpl parcelImpl) throws RemoteException;

    void getItem(IMediaController iMediaController, int i, String str) throws RemoteException;

    void getLibraryRoot(IMediaController iMediaController, int i, ParcelImpl parcelImpl) throws RemoteException;

    void getSearchResult(IMediaController iMediaController, int i, String str, int i2, int i3, ParcelImpl parcelImpl) throws RemoteException;

    void movePlaylistItem(IMediaController iMediaController, int i, int i2, int i3) throws RemoteException;

    void onControllerResult(IMediaController iMediaController, int i, ParcelImpl parcelImpl) throws RemoteException;

    void onCustomCommand(IMediaController iMediaController, int i, ParcelImpl parcelImpl, Bundle bundle) throws RemoteException;

    void pause(IMediaController iMediaController, int i) throws RemoteException;

    void play(IMediaController iMediaController, int i) throws RemoteException;

    void prepare(IMediaController iMediaController, int i) throws RemoteException;

    void release(IMediaController iMediaController, int i) throws RemoteException;

    void removePlaylistItem(IMediaController iMediaController, int i, int i2) throws RemoteException;

    void replacePlaylistItem(IMediaController iMediaController, int i, int i2, String str) throws RemoteException;

    void rewind(IMediaController iMediaController, int i) throws RemoteException;

    void search(IMediaController iMediaController, int i, String str, ParcelImpl parcelImpl) throws RemoteException;

    void seekTo(IMediaController iMediaController, int i, long j) throws RemoteException;

    void selectTrack(IMediaController iMediaController, int i, ParcelImpl parcelImpl) throws RemoteException;

    void setMediaItem(IMediaController iMediaController, int i, String str) throws RemoteException;

    void setMediaUri(IMediaController iMediaController, int i, Uri uri, Bundle bundle) throws RemoteException;

    void setPlaybackSpeed(IMediaController iMediaController, int i, float f) throws RemoteException;

    void setPlaylist(IMediaController iMediaController, int i, List<String> list, ParcelImpl parcelImpl) throws RemoteException;

    void setRating(IMediaController iMediaController, int i, String str, ParcelImpl parcelImpl) throws RemoteException;

    void setRepeatMode(IMediaController iMediaController, int i, int i2) throws RemoteException;

    void setShuffleMode(IMediaController iMediaController, int i, int i2) throws RemoteException;

    void setSurface(IMediaController iMediaController, int i, Surface surface) throws RemoteException;

    void setVolumeTo(IMediaController iMediaController, int i, int i2, int i3) throws RemoteException;

    void skipBackward(IMediaController iMediaController, int i) throws RemoteException;

    void skipForward(IMediaController iMediaController, int i) throws RemoteException;

    void skipToNextItem(IMediaController iMediaController, int i) throws RemoteException;

    void skipToPlaylistItem(IMediaController iMediaController, int i, int i2) throws RemoteException;

    void skipToPreviousItem(IMediaController iMediaController, int i) throws RemoteException;

    void subscribe(IMediaController iMediaController, int i, String str, ParcelImpl parcelImpl) throws RemoteException;

    void unsubscribe(IMediaController iMediaController, int i, String str) throws RemoteException;

    void updatePlaylistMetadata(IMediaController iMediaController, int i, ParcelImpl parcelImpl) throws RemoteException;
}

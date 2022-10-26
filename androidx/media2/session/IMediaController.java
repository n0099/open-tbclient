package androidx.media2.session;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.core.view.InputDeviceCompat;
import androidx.media2.common.ParcelImplListSlice;
import androidx.versionedparcelable.ParcelImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public interface IMediaController extends IInterface {
    void onAllowedCommandsChanged(int i, ParcelImpl parcelImpl) throws RemoteException;

    void onBufferingStateChanged(int i, ParcelImpl parcelImpl, int i2, long j, long j2, long j3) throws RemoteException;

    void onChildrenChanged(int i, String str, int i2, ParcelImpl parcelImpl) throws RemoteException;

    void onConnected(int i, ParcelImpl parcelImpl) throws RemoteException;

    void onCurrentMediaItemChanged(int i, ParcelImpl parcelImpl, int i2, int i3, int i4) throws RemoteException;

    void onCustomCommand(int i, ParcelImpl parcelImpl, Bundle bundle) throws RemoteException;

    void onDisconnected(int i) throws RemoteException;

    void onLibraryResult(int i, ParcelImpl parcelImpl) throws RemoteException;

    void onPlaybackCompleted(int i) throws RemoteException;

    void onPlaybackInfoChanged(int i, ParcelImpl parcelImpl) throws RemoteException;

    void onPlaybackSpeedChanged(int i, long j, long j2, float f) throws RemoteException;

    void onPlayerStateChanged(int i, long j, long j2, int i2) throws RemoteException;

    void onPlaylistChanged(int i, ParcelImplListSlice parcelImplListSlice, ParcelImpl parcelImpl, int i2, int i3, int i4) throws RemoteException;

    void onPlaylistMetadataChanged(int i, ParcelImpl parcelImpl) throws RemoteException;

    void onRepeatModeChanged(int i, int i2, int i3, int i4, int i5) throws RemoteException;

    void onSearchResultChanged(int i, String str, int i2, ParcelImpl parcelImpl) throws RemoteException;

    void onSeekCompleted(int i, long j, long j2, long j3) throws RemoteException;

    void onSessionResult(int i, ParcelImpl parcelImpl) throws RemoteException;

    void onSetCustomLayout(int i, List list) throws RemoteException;

    void onShuffleModeChanged(int i, int i2, int i3, int i4, int i5) throws RemoteException;

    void onSubtitleData(int i, ParcelImpl parcelImpl, ParcelImpl parcelImpl2, ParcelImpl parcelImpl3) throws RemoteException;

    void onTrackDeselected(int i, ParcelImpl parcelImpl) throws RemoteException;

    void onTrackInfoChanged(int i, List list, ParcelImpl parcelImpl, ParcelImpl parcelImpl2, ParcelImpl parcelImpl3, ParcelImpl parcelImpl4) throws RemoteException;

    void onTrackSelected(int i, ParcelImpl parcelImpl) throws RemoteException;

    void onVideoSizeChanged(int i, ParcelImpl parcelImpl, ParcelImpl parcelImpl2) throws RemoteException;

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IMediaController {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String DESCRIPTOR = "androidx.media2.session.IMediaController";
        public static final int TRANSACTION_onAllowedCommandsChanged = 15;
        public static final int TRANSACTION_onBufferingStateChanged = 4;
        public static final int TRANSACTION_onChildrenChanged = 19;
        public static final int TRANSACTION_onConnected = 12;
        public static final int TRANSACTION_onCurrentMediaItemChanged = 1;
        public static final int TRANSACTION_onCustomCommand = 16;
        public static final int TRANSACTION_onDisconnected = 13;
        public static final int TRANSACTION_onLibraryResult = 18;
        public static final int TRANSACTION_onPlaybackCompleted = 10;
        public static final int TRANSACTION_onPlaybackInfoChanged = 7;
        public static final int TRANSACTION_onPlaybackSpeedChanged = 3;
        public static final int TRANSACTION_onPlayerStateChanged = 2;
        public static final int TRANSACTION_onPlaylistChanged = 5;
        public static final int TRANSACTION_onPlaylistMetadataChanged = 6;
        public static final int TRANSACTION_onRepeatModeChanged = 8;
        public static final int TRANSACTION_onSearchResultChanged = 20;
        public static final int TRANSACTION_onSeekCompleted = 11;
        public static final int TRANSACTION_onSessionResult = 17;
        public static final int TRANSACTION_onSetCustomLayout = 14;
        public static final int TRANSACTION_onShuffleModeChanged = 9;
        public static final int TRANSACTION_onSubtitleData = 25;
        public static final int TRANSACTION_onTrackDeselected = 24;
        public static final int TRANSACTION_onTrackInfoChanged = 22;
        public static final int TRANSACTION_onTrackSelected = 23;
        public static final int TRANSACTION_onVideoSizeChanged = 21;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this : (IBinder) invokeV.objValue;
        }

        /* loaded from: classes.dex */
        public static class Proxy implements IMediaController {
            public static /* synthetic */ Interceptable $ic;
            public static IMediaController sDefaultImpl;
            public transient /* synthetic */ FieldHolder $fh;
            public IBinder mRemote;

            public String getInterfaceDescriptor() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Stub.DESCRIPTOR : (String) invokeV.objValue;
            }

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

            @Override // android.os.IInterface
            public IBinder asBinder() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    return this.mRemote;
                }
                return (IBinder) invokeV.objValue;
            }

            @Override // androidx.media2.session.IMediaController
            public void onAllowedCommandsChanged(int i, ParcelImpl parcelImpl) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, parcelImpl) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeInt(i);
                        if (parcelImpl != null) {
                            obtain.writeInt(1);
                            parcelImpl.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        if (!this.mRemote.transact(15, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                            Stub.getDefaultImpl().onAllowedCommandsChanged(i, parcelImpl);
                        }
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // androidx.media2.session.IMediaController
            public void onConnected(int i, ParcelImpl parcelImpl) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048581, this, i, parcelImpl) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeInt(i);
                        if (parcelImpl != null) {
                            obtain.writeInt(1);
                            parcelImpl.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        if (!this.mRemote.transact(12, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                            Stub.getDefaultImpl().onConnected(i, parcelImpl);
                        }
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // androidx.media2.session.IMediaController
            public void onLibraryResult(int i, ParcelImpl parcelImpl) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048585, this, i, parcelImpl) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeInt(i);
                        if (parcelImpl != null) {
                            obtain.writeInt(1);
                            parcelImpl.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        if (!this.mRemote.transact(18, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                            Stub.getDefaultImpl().onLibraryResult(i, parcelImpl);
                        }
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // androidx.media2.session.IMediaController
            public void onPlaybackInfoChanged(int i, ParcelImpl parcelImpl) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048587, this, i, parcelImpl) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeInt(i);
                        if (parcelImpl != null) {
                            obtain.writeInt(1);
                            parcelImpl.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        if (!this.mRemote.transact(7, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                            Stub.getDefaultImpl().onPlaybackInfoChanged(i, parcelImpl);
                        }
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // androidx.media2.session.IMediaController
            public void onPlaylistMetadataChanged(int i, ParcelImpl parcelImpl) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048591, this, i, parcelImpl) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeInt(i);
                        if (parcelImpl != null) {
                            obtain.writeInt(1);
                            parcelImpl.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        if (!this.mRemote.transact(6, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                            Stub.getDefaultImpl().onPlaylistMetadataChanged(i, parcelImpl);
                        }
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // androidx.media2.session.IMediaController
            public void onSessionResult(int i, ParcelImpl parcelImpl) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048595, this, i, parcelImpl) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeInt(i);
                        if (parcelImpl != null) {
                            obtain.writeInt(1);
                            parcelImpl.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        if (!this.mRemote.transact(17, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                            Stub.getDefaultImpl().onSessionResult(i, parcelImpl);
                        }
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // androidx.media2.session.IMediaController
            public void onTrackDeselected(int i, ParcelImpl parcelImpl) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048599, this, i, parcelImpl) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeInt(i);
                        if (parcelImpl != null) {
                            obtain.writeInt(1);
                            parcelImpl.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        if (!this.mRemote.transact(24, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                            Stub.getDefaultImpl().onTrackDeselected(i, parcelImpl);
                        }
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // androidx.media2.session.IMediaController
            public void onTrackSelected(int i, ParcelImpl parcelImpl) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048601, this, i, parcelImpl) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeInt(i);
                        if (parcelImpl != null) {
                            obtain.writeInt(1);
                            parcelImpl.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        if (!this.mRemote.transact(23, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                            Stub.getDefaultImpl().onTrackSelected(i, parcelImpl);
                        }
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // androidx.media2.session.IMediaController
            public void onBufferingStateChanged(int i, ParcelImpl parcelImpl, int i2, long j, long j2, long j3) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), parcelImpl, Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeInt(i);
                        if (parcelImpl != null) {
                            obtain.writeInt(1);
                            parcelImpl.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        obtain.writeInt(i2);
                        obtain.writeLong(j);
                        obtain.writeLong(j2);
                        obtain.writeLong(j3);
                        try {
                            if (!this.mRemote.transact(4, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                                Stub.getDefaultImpl().onBufferingStateChanged(i, parcelImpl, i2, j, j2, j3);
                                obtain.recycle();
                                return;
                            }
                            obtain.recycle();
                        } catch (Throwable th) {
                            th = th;
                            obtain.recycle();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            }

            @Override // androidx.media2.session.IMediaController
            public void onTrackInfoChanged(int i, List<ParcelImpl> list, ParcelImpl parcelImpl, ParcelImpl parcelImpl2, ParcelImpl parcelImpl3, ParcelImpl parcelImpl4) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Integer.valueOf(i), list, parcelImpl, parcelImpl2, parcelImpl3, parcelImpl4}) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeInt(i);
                        obtain.writeTypedList(list);
                        if (parcelImpl != null) {
                            obtain.writeInt(1);
                            parcelImpl.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        if (parcelImpl2 != null) {
                            obtain.writeInt(1);
                            parcelImpl2.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        if (parcelImpl3 != null) {
                            obtain.writeInt(1);
                            parcelImpl3.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        if (parcelImpl4 != null) {
                            obtain.writeInt(1);
                            parcelImpl4.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        if (!this.mRemote.transact(22, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                            Stub.getDefaultImpl().onTrackInfoChanged(i, list, parcelImpl, parcelImpl2, parcelImpl3, parcelImpl4);
                        }
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // androidx.media2.session.IMediaController
            public void onChildrenChanged(int i, String str, int i2, ParcelImpl parcelImpl) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), parcelImpl}) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeInt(i);
                        obtain.writeString(str);
                        obtain.writeInt(i2);
                        if (parcelImpl != null) {
                            obtain.writeInt(1);
                            parcelImpl.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        if (!this.mRemote.transact(19, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                            Stub.getDefaultImpl().onChildrenChanged(i, str, i2, parcelImpl);
                        }
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // androidx.media2.session.IMediaController
            public void onPlaybackSpeedChanged(int i, long j, long j2, float f) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Float.valueOf(f)}) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeInt(i);
                        obtain.writeLong(j);
                        obtain.writeLong(j2);
                        obtain.writeFloat(f);
                        if (!this.mRemote.transact(3, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                            Stub.getDefaultImpl().onPlaybackSpeedChanged(i, j, j2, f);
                        }
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // androidx.media2.session.IMediaController
            public void onPlayerStateChanged(int i, long j, long j2, int i2) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeInt(i);
                        obtain.writeLong(j);
                        obtain.writeLong(j2);
                        obtain.writeInt(i2);
                        if (!this.mRemote.transact(2, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                            Stub.getDefaultImpl().onPlayerStateChanged(i, j, j2, i2);
                        }
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // androidx.media2.session.IMediaController
            public void onSearchResultChanged(int i, String str, int i2, ParcelImpl parcelImpl) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), parcelImpl}) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeInt(i);
                        obtain.writeString(str);
                        obtain.writeInt(i2);
                        if (parcelImpl != null) {
                            obtain.writeInt(1);
                            parcelImpl.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        if (!this.mRemote.transact(20, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                            Stub.getDefaultImpl().onSearchResultChanged(i, str, i2, parcelImpl);
                        }
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // androidx.media2.session.IMediaController
            public void onSeekCompleted(int i, long j, long j2, long j3) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeInt(i);
                        obtain.writeLong(j);
                        obtain.writeLong(j2);
                        obtain.writeLong(j3);
                        try {
                            if (!this.mRemote.transact(11, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                                Stub.getDefaultImpl().onSeekCompleted(i, j, j2, j3);
                                obtain.recycle();
                                return;
                            }
                            obtain.recycle();
                        } catch (Throwable th) {
                            th = th;
                            obtain.recycle();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            }

            @Override // androidx.media2.session.IMediaController
            public void onSubtitleData(int i, ParcelImpl parcelImpl, ParcelImpl parcelImpl2, ParcelImpl parcelImpl3) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Integer.valueOf(i), parcelImpl, parcelImpl2, parcelImpl3}) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeInt(i);
                        if (parcelImpl != null) {
                            obtain.writeInt(1);
                            parcelImpl.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        if (parcelImpl2 != null) {
                            obtain.writeInt(1);
                            parcelImpl2.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        if (parcelImpl3 != null) {
                            obtain.writeInt(1);
                            parcelImpl3.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        if (!this.mRemote.transact(25, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                            Stub.getDefaultImpl().onSubtitleData(i, parcelImpl, parcelImpl2, parcelImpl3);
                        }
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // androidx.media2.session.IMediaController
            public void onCurrentMediaItemChanged(int i, ParcelImpl parcelImpl, int i2, int i3, int i4) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), parcelImpl, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeInt(i);
                        if (parcelImpl != null) {
                            obtain.writeInt(1);
                            parcelImpl.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        obtain.writeInt(i2);
                        obtain.writeInt(i3);
                        obtain.writeInt(i4);
                        if (!this.mRemote.transact(1, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                            Stub.getDefaultImpl().onCurrentMediaItemChanged(i, parcelImpl, i2, i3, i4);
                        }
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // androidx.media2.session.IMediaController
            public void onRepeatModeChanged(int i, int i2, int i3, int i4, int i5) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeInt(i);
                        obtain.writeInt(i2);
                        obtain.writeInt(i3);
                        obtain.writeInt(i4);
                        obtain.writeInt(i5);
                        if (!this.mRemote.transact(8, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                            Stub.getDefaultImpl().onRepeatModeChanged(i, i2, i3, i4, i5);
                        }
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // androidx.media2.session.IMediaController
            public void onShuffleModeChanged(int i, int i2, int i3, int i4, int i5) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeInt(i);
                        obtain.writeInt(i2);
                        obtain.writeInt(i3);
                        obtain.writeInt(i4);
                        obtain.writeInt(i5);
                        if (!this.mRemote.transact(9, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                            Stub.getDefaultImpl().onShuffleModeChanged(i, i2, i3, i4, i5);
                        }
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // androidx.media2.session.IMediaController
            public void onCustomCommand(int i, ParcelImpl parcelImpl, Bundle bundle) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeILL(1048583, this, i, parcelImpl, bundle) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
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
                        if (!this.mRemote.transact(16, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                            Stub.getDefaultImpl().onCustomCommand(i, parcelImpl, bundle);
                        }
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // androidx.media2.session.IMediaController
            public void onVideoSizeChanged(int i, ParcelImpl parcelImpl, ParcelImpl parcelImpl2) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeILL(1048602, this, i, parcelImpl, parcelImpl2) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeInt(i);
                        if (parcelImpl != null) {
                            obtain.writeInt(1);
                            parcelImpl.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        if (parcelImpl2 != null) {
                            obtain.writeInt(1);
                            parcelImpl2.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        if (!this.mRemote.transact(21, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                            Stub.getDefaultImpl().onVideoSizeChanged(i, parcelImpl, parcelImpl2);
                        }
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // androidx.media2.session.IMediaController
            public void onDisconnected(int i) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeInt(i);
                        if (!this.mRemote.transact(13, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                            Stub.getDefaultImpl().onDisconnected(i);
                        }
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // androidx.media2.session.IMediaController
            public void onPlaybackCompleted(int i) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeInt(i);
                        if (!this.mRemote.transact(10, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                            Stub.getDefaultImpl().onPlaybackCompleted(i);
                        }
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // androidx.media2.session.IMediaController
            public void onPlaylistChanged(int i, ParcelImplListSlice parcelImplListSlice, ParcelImpl parcelImpl, int i2, int i3, int i4) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i), parcelImplListSlice, parcelImpl, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeInt(i);
                        if (parcelImplListSlice != null) {
                            obtain.writeInt(1);
                            parcelImplListSlice.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        if (parcelImpl != null) {
                            obtain.writeInt(1);
                            parcelImpl.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        obtain.writeInt(i2);
                        obtain.writeInt(i3);
                        obtain.writeInt(i4);
                        if (!this.mRemote.transact(5, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                            Stub.getDefaultImpl().onPlaylistChanged(i, parcelImplListSlice, parcelImpl, i2, i3, i4);
                        }
                    } finally {
                        obtain.recycle();
                    }
                }
            }

            @Override // androidx.media2.session.IMediaController
            public void onSetCustomLayout(int i, List<ParcelImpl> list) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(1048596, this, i, list) == null) {
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeInt(i);
                        obtain.writeTypedList(list);
                        if (!this.mRemote.transact(14, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                            Stub.getDefaultImpl().onSetCustomLayout(i, list);
                        }
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

        public static IMediaController getDefaultImpl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
                return Proxy.sDefaultImpl;
            }
            return (IMediaController) invokeV.objValue;
        }

        public static IMediaController asInterface(IBinder iBinder) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, iBinder)) == null) {
                if (iBinder == null) {
                    return null;
                }
                IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
                if (queryLocalInterface != null && (queryLocalInterface instanceof IMediaController)) {
                    return (IMediaController) queryLocalInterface;
                }
                return new Proxy(iBinder);
            }
            return (IMediaController) invokeL.objValue;
        }

        public static boolean setDefaultImpl(IMediaController iMediaController) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, iMediaController)) == null) {
                if (Proxy.sDefaultImpl == null && iMediaController != null) {
                    Proxy.sDefaultImpl = iMediaController;
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            InterceptResult invokeCommon;
            ParcelImplListSlice parcelImplListSlice;
            ParcelImpl parcelImpl;
            ParcelImpl parcelImpl2;
            ParcelImpl parcelImpl3;
            ParcelImpl parcelImpl4;
            ParcelImpl parcelImpl5;
            ParcelImpl parcelImpl6;
            ParcelImpl parcelImpl7;
            ParcelImpl parcelImpl8;
            ParcelImpl parcelImpl9;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), parcel, parcel2, Integer.valueOf(i2)})) == null) {
                if (i != 1598968902) {
                    ParcelImpl parcelImpl10 = null;
                    ParcelImpl parcelImpl11 = null;
                    ParcelImpl parcelImpl12 = null;
                    ParcelImpl parcelImpl13 = null;
                    ParcelImpl parcelImpl14 = null;
                    ParcelImpl parcelImpl15 = null;
                    ParcelImpl parcelImpl16 = null;
                    ParcelImpl parcelImpl17 = null;
                    ParcelImpl parcelImpl18 = null;
                    Bundle bundle = null;
                    ParcelImpl parcelImpl19 = null;
                    ParcelImpl parcelImpl20 = null;
                    ParcelImpl parcelImpl21 = null;
                    ParcelImpl parcelImpl22 = null;
                    ParcelImpl parcelImpl23 = null;
                    switch (i) {
                        case 1:
                            parcel.enforceInterface(DESCRIPTOR);
                            int readInt = parcel.readInt();
                            if (parcel.readInt() != 0) {
                                parcelImpl10 = ParcelImpl.CREATOR.createFromParcel(parcel);
                            }
                            onCurrentMediaItemChanged(readInt, parcelImpl10, parcel.readInt(), parcel.readInt(), parcel.readInt());
                            return true;
                        case 2:
                            parcel.enforceInterface(DESCRIPTOR);
                            onPlayerStateChanged(parcel.readInt(), parcel.readLong(), parcel.readLong(), parcel.readInt());
                            return true;
                        case 3:
                            parcel.enforceInterface(DESCRIPTOR);
                            onPlaybackSpeedChanged(parcel.readInt(), parcel.readLong(), parcel.readLong(), parcel.readFloat());
                            return true;
                        case 4:
                            parcel.enforceInterface(DESCRIPTOR);
                            int readInt2 = parcel.readInt();
                            if (parcel.readInt() != 0) {
                                parcelImpl23 = ParcelImpl.CREATOR.createFromParcel(parcel);
                            }
                            onBufferingStateChanged(readInt2, parcelImpl23, parcel.readInt(), parcel.readLong(), parcel.readLong(), parcel.readLong());
                            return true;
                        case 5:
                            parcel.enforceInterface(DESCRIPTOR);
                            int readInt3 = parcel.readInt();
                            if (parcel.readInt() != 0) {
                                parcelImplListSlice = ParcelImplListSlice.CREATOR.createFromParcel(parcel);
                            } else {
                                parcelImplListSlice = null;
                            }
                            if (parcel.readInt() != 0) {
                                parcelImpl = ParcelImpl.CREATOR.createFromParcel(parcel);
                            } else {
                                parcelImpl = null;
                            }
                            onPlaylistChanged(readInt3, parcelImplListSlice, parcelImpl, parcel.readInt(), parcel.readInt(), parcel.readInt());
                            return true;
                        case 6:
                            parcel.enforceInterface(DESCRIPTOR);
                            int readInt4 = parcel.readInt();
                            if (parcel.readInt() != 0) {
                                parcelImpl22 = ParcelImpl.CREATOR.createFromParcel(parcel);
                            }
                            onPlaylistMetadataChanged(readInt4, parcelImpl22);
                            return true;
                        case 7:
                            parcel.enforceInterface(DESCRIPTOR);
                            int readInt5 = parcel.readInt();
                            if (parcel.readInt() != 0) {
                                parcelImpl21 = ParcelImpl.CREATOR.createFromParcel(parcel);
                            }
                            onPlaybackInfoChanged(readInt5, parcelImpl21);
                            return true;
                        case 8:
                            parcel.enforceInterface(DESCRIPTOR);
                            onRepeatModeChanged(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                            return true;
                        case 9:
                            parcel.enforceInterface(DESCRIPTOR);
                            onShuffleModeChanged(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                            return true;
                        case 10:
                            parcel.enforceInterface(DESCRIPTOR);
                            onPlaybackCompleted(parcel.readInt());
                            return true;
                        case 11:
                            parcel.enforceInterface(DESCRIPTOR);
                            onSeekCompleted(parcel.readInt(), parcel.readLong(), parcel.readLong(), parcel.readLong());
                            return true;
                        case 12:
                            parcel.enforceInterface(DESCRIPTOR);
                            int readInt6 = parcel.readInt();
                            if (parcel.readInt() != 0) {
                                parcelImpl20 = ParcelImpl.CREATOR.createFromParcel(parcel);
                            }
                            onConnected(readInt6, parcelImpl20);
                            return true;
                        case 13:
                            parcel.enforceInterface(DESCRIPTOR);
                            onDisconnected(parcel.readInt());
                            return true;
                        case 14:
                            parcel.enforceInterface(DESCRIPTOR);
                            onSetCustomLayout(parcel.readInt(), parcel.createTypedArrayList(ParcelImpl.CREATOR));
                            return true;
                        case 15:
                            parcel.enforceInterface(DESCRIPTOR);
                            int readInt7 = parcel.readInt();
                            if (parcel.readInt() != 0) {
                                parcelImpl19 = ParcelImpl.CREATOR.createFromParcel(parcel);
                            }
                            onAllowedCommandsChanged(readInt7, parcelImpl19);
                            return true;
                        case 16:
                            parcel.enforceInterface(DESCRIPTOR);
                            int readInt8 = parcel.readInt();
                            if (parcel.readInt() != 0) {
                                parcelImpl2 = ParcelImpl.CREATOR.createFromParcel(parcel);
                            } else {
                                parcelImpl2 = null;
                            }
                            if (parcel.readInt() != 0) {
                                bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                            }
                            onCustomCommand(readInt8, parcelImpl2, bundle);
                            return true;
                        case 17:
                            parcel.enforceInterface(DESCRIPTOR);
                            int readInt9 = parcel.readInt();
                            if (parcel.readInt() != 0) {
                                parcelImpl18 = ParcelImpl.CREATOR.createFromParcel(parcel);
                            }
                            onSessionResult(readInt9, parcelImpl18);
                            return true;
                        case 18:
                            parcel.enforceInterface(DESCRIPTOR);
                            int readInt10 = parcel.readInt();
                            if (parcel.readInt() != 0) {
                                parcelImpl17 = ParcelImpl.CREATOR.createFromParcel(parcel);
                            }
                            onLibraryResult(readInt10, parcelImpl17);
                            return true;
                        case 19:
                            parcel.enforceInterface(DESCRIPTOR);
                            int readInt11 = parcel.readInt();
                            String readString = parcel.readString();
                            int readInt12 = parcel.readInt();
                            if (parcel.readInt() != 0) {
                                parcelImpl16 = ParcelImpl.CREATOR.createFromParcel(parcel);
                            }
                            onChildrenChanged(readInt11, readString, readInt12, parcelImpl16);
                            return true;
                        case 20:
                            parcel.enforceInterface(DESCRIPTOR);
                            int readInt13 = parcel.readInt();
                            String readString2 = parcel.readString();
                            int readInt14 = parcel.readInt();
                            if (parcel.readInt() != 0) {
                                parcelImpl15 = ParcelImpl.CREATOR.createFromParcel(parcel);
                            }
                            onSearchResultChanged(readInt13, readString2, readInt14, parcelImpl15);
                            return true;
                        case 21:
                            parcel.enforceInterface(DESCRIPTOR);
                            int readInt15 = parcel.readInt();
                            if (parcel.readInt() != 0) {
                                parcelImpl3 = ParcelImpl.CREATOR.createFromParcel(parcel);
                            } else {
                                parcelImpl3 = null;
                            }
                            if (parcel.readInt() != 0) {
                                parcelImpl14 = ParcelImpl.CREATOR.createFromParcel(parcel);
                            }
                            onVideoSizeChanged(readInt15, parcelImpl3, parcelImpl14);
                            return true;
                        case 22:
                            parcel.enforceInterface(DESCRIPTOR);
                            int readInt16 = parcel.readInt();
                            ArrayList createTypedArrayList = parcel.createTypedArrayList(ParcelImpl.CREATOR);
                            if (parcel.readInt() != 0) {
                                parcelImpl4 = ParcelImpl.CREATOR.createFromParcel(parcel);
                            } else {
                                parcelImpl4 = null;
                            }
                            if (parcel.readInt() != 0) {
                                parcelImpl5 = ParcelImpl.CREATOR.createFromParcel(parcel);
                            } else {
                                parcelImpl5 = null;
                            }
                            if (parcel.readInt() != 0) {
                                parcelImpl6 = ParcelImpl.CREATOR.createFromParcel(parcel);
                            } else {
                                parcelImpl6 = null;
                            }
                            if (parcel.readInt() != 0) {
                                parcelImpl7 = ParcelImpl.CREATOR.createFromParcel(parcel);
                            } else {
                                parcelImpl7 = null;
                            }
                            onTrackInfoChanged(readInt16, createTypedArrayList, parcelImpl4, parcelImpl5, parcelImpl6, parcelImpl7);
                            return true;
                        case 23:
                            parcel.enforceInterface(DESCRIPTOR);
                            int readInt17 = parcel.readInt();
                            if (parcel.readInt() != 0) {
                                parcelImpl13 = ParcelImpl.CREATOR.createFromParcel(parcel);
                            }
                            onTrackSelected(readInt17, parcelImpl13);
                            return true;
                        case 24:
                            parcel.enforceInterface(DESCRIPTOR);
                            int readInt18 = parcel.readInt();
                            if (parcel.readInt() != 0) {
                                parcelImpl12 = ParcelImpl.CREATOR.createFromParcel(parcel);
                            }
                            onTrackDeselected(readInt18, parcelImpl12);
                            return true;
                        case 25:
                            parcel.enforceInterface(DESCRIPTOR);
                            int readInt19 = parcel.readInt();
                            if (parcel.readInt() != 0) {
                                parcelImpl8 = ParcelImpl.CREATOR.createFromParcel(parcel);
                            } else {
                                parcelImpl8 = null;
                            }
                            if (parcel.readInt() != 0) {
                                parcelImpl9 = ParcelImpl.CREATOR.createFromParcel(parcel);
                            } else {
                                parcelImpl9 = null;
                            }
                            if (parcel.readInt() != 0) {
                                parcelImpl11 = ParcelImpl.CREATOR.createFromParcel(parcel);
                            }
                            onSubtitleData(readInt19, parcelImpl8, parcelImpl9, parcelImpl11);
                            return true;
                        default:
                            return super.onTransact(i, parcel, parcel2, i2);
                    }
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public static class Default implements IMediaController {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return null;
            }
            return (IBinder) invokeV.objValue;
        }

        @Override // androidx.media2.session.IMediaController
        public void onAllowedCommandsChanged(int i, ParcelImpl parcelImpl) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, parcelImpl) == null) {
            }
        }

        @Override // androidx.media2.session.IMediaController
        public void onBufferingStateChanged(int i, ParcelImpl parcelImpl, int i2, long j, long j2, long j3) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), parcelImpl, Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            }
        }

        @Override // androidx.media2.session.IMediaController
        public void onChildrenChanged(int i, String str, int i2, ParcelImpl parcelImpl) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), parcelImpl}) == null) {
            }
        }

        @Override // androidx.media2.session.IMediaController
        public void onConnected(int i, ParcelImpl parcelImpl) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048580, this, i, parcelImpl) == null) {
            }
        }

        @Override // androidx.media2.session.IMediaController
        public void onCurrentMediaItemChanged(int i, ParcelImpl parcelImpl, int i2, int i3, int i4) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), parcelImpl, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            }
        }

        @Override // androidx.media2.session.IMediaController
        public void onCustomCommand(int i, ParcelImpl parcelImpl, Bundle bundle) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048582, this, i, parcelImpl, bundle) == null) {
            }
        }

        @Override // androidx.media2.session.IMediaController
        public void onDisconnected(int i) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            }
        }

        @Override // androidx.media2.session.IMediaController
        public void onLibraryResult(int i, ParcelImpl parcelImpl) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, parcelImpl) == null) {
            }
        }

        @Override // androidx.media2.session.IMediaController
        public void onPlaybackCompleted(int i) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            }
        }

        @Override // androidx.media2.session.IMediaController
        public void onPlaybackInfoChanged(int i, ParcelImpl parcelImpl) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048586, this, i, parcelImpl) == null) {
            }
        }

        @Override // androidx.media2.session.IMediaController
        public void onPlaybackSpeedChanged(int i, long j, long j2, float f) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Float.valueOf(f)}) == null) {
            }
        }

        @Override // androidx.media2.session.IMediaController
        public void onPlayerStateChanged(int i, long j, long j2, int i2) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
            }
        }

        @Override // androidx.media2.session.IMediaController
        public void onPlaylistChanged(int i, ParcelImplListSlice parcelImplListSlice, ParcelImpl parcelImpl, int i2, int i3, int i4) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i), parcelImplListSlice, parcelImpl, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            }
        }

        @Override // androidx.media2.session.IMediaController
        public void onPlaylistMetadataChanged(int i, ParcelImpl parcelImpl) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048590, this, i, parcelImpl) == null) {
            }
        }

        @Override // androidx.media2.session.IMediaController
        public void onRepeatModeChanged(int i, int i2, int i3, int i4, int i5) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            }
        }

        @Override // androidx.media2.session.IMediaController
        public void onSearchResultChanged(int i, String str, int i2, ParcelImpl parcelImpl) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), parcelImpl}) == null) {
            }
        }

        @Override // androidx.media2.session.IMediaController
        public void onSeekCompleted(int i, long j, long j2, long j3) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            }
        }

        @Override // androidx.media2.session.IMediaController
        public void onSessionResult(int i, ParcelImpl parcelImpl) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048594, this, i, parcelImpl) == null) {
            }
        }

        @Override // androidx.media2.session.IMediaController
        public void onSetCustomLayout(int i, List<ParcelImpl> list) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048595, this, i, list) == null) {
            }
        }

        @Override // androidx.media2.session.IMediaController
        public void onShuffleModeChanged(int i, int i2, int i3, int i4, int i5) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            }
        }

        @Override // androidx.media2.session.IMediaController
        public void onSubtitleData(int i, ParcelImpl parcelImpl, ParcelImpl parcelImpl2, ParcelImpl parcelImpl3) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Integer.valueOf(i), parcelImpl, parcelImpl2, parcelImpl3}) == null) {
            }
        }

        @Override // androidx.media2.session.IMediaController
        public void onTrackDeselected(int i, ParcelImpl parcelImpl) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048598, this, i, parcelImpl) == null) {
            }
        }

        @Override // androidx.media2.session.IMediaController
        public void onTrackInfoChanged(int i, List<ParcelImpl> list, ParcelImpl parcelImpl, ParcelImpl parcelImpl2, ParcelImpl parcelImpl3, ParcelImpl parcelImpl4) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Integer.valueOf(i), list, parcelImpl, parcelImpl2, parcelImpl3, parcelImpl4}) == null) {
            }
        }

        @Override // androidx.media2.session.IMediaController
        public void onTrackSelected(int i, ParcelImpl parcelImpl) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048600, this, i, parcelImpl) == null) {
            }
        }

        @Override // androidx.media2.session.IMediaController
        public void onVideoSizeChanged(int i, ParcelImpl parcelImpl, ParcelImpl parcelImpl2) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048601, this, i, parcelImpl, parcelImpl2) == null) {
            }
        }

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
    }
}

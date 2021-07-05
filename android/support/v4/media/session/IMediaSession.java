package android.support.v4.media.session;

import android.app.PendingIntent;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.IMediaControllerCallback;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import android.view.KeyEvent;
import androidx.core.view.InputDeviceCompat;
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
    public static abstract class Stub extends Binder implements IMediaSession {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String DESCRIPTOR = "android.support.v4.media.session.IMediaSession";
        public static final int TRANSACTION_addQueueItem = 41;
        public static final int TRANSACTION_addQueueItemAt = 42;
        public static final int TRANSACTION_adjustVolume = 11;
        public static final int TRANSACTION_fastForward = 22;
        public static final int TRANSACTION_getExtras = 31;
        public static final int TRANSACTION_getFlags = 9;
        public static final int TRANSACTION_getLaunchPendingIntent = 8;
        public static final int TRANSACTION_getMetadata = 27;
        public static final int TRANSACTION_getPackageName = 6;
        public static final int TRANSACTION_getPlaybackState = 28;
        public static final int TRANSACTION_getQueue = 29;
        public static final int TRANSACTION_getQueueTitle = 30;
        public static final int TRANSACTION_getRatingType = 32;
        public static final int TRANSACTION_getRepeatMode = 37;
        public static final int TRANSACTION_getShuffleMode = 47;
        public static final int TRANSACTION_getTag = 7;
        public static final int TRANSACTION_getVolumeAttributes = 10;
        public static final int TRANSACTION_isCaptioningEnabled = 45;
        public static final int TRANSACTION_isShuffleModeEnabledRemoved = 38;
        public static final int TRANSACTION_isTransportControlEnabled = 5;
        public static final int TRANSACTION_next = 20;
        public static final int TRANSACTION_pause = 18;
        public static final int TRANSACTION_play = 13;
        public static final int TRANSACTION_playFromMediaId = 14;
        public static final int TRANSACTION_playFromSearch = 15;
        public static final int TRANSACTION_playFromUri = 16;
        public static final int TRANSACTION_prepare = 33;
        public static final int TRANSACTION_prepareFromMediaId = 34;
        public static final int TRANSACTION_prepareFromSearch = 35;
        public static final int TRANSACTION_prepareFromUri = 36;
        public static final int TRANSACTION_previous = 21;
        public static final int TRANSACTION_rate = 25;
        public static final int TRANSACTION_rateWithExtras = 51;
        public static final int TRANSACTION_registerCallbackListener = 3;
        public static final int TRANSACTION_removeQueueItem = 43;
        public static final int TRANSACTION_removeQueueItemAt = 44;
        public static final int TRANSACTION_rewind = 23;
        public static final int TRANSACTION_seekTo = 24;
        public static final int TRANSACTION_sendCommand = 1;
        public static final int TRANSACTION_sendCustomAction = 26;
        public static final int TRANSACTION_sendMediaButton = 2;
        public static final int TRANSACTION_setCaptioningEnabled = 46;
        public static final int TRANSACTION_setRepeatMode = 39;
        public static final int TRANSACTION_setShuffleMode = 48;
        public static final int TRANSACTION_setShuffleModeEnabledRemoved = 40;
        public static final int TRANSACTION_setVolumeTo = 12;
        public static final int TRANSACTION_skipToQueueItem = 17;
        public static final int TRANSACTION_stop = 19;
        public static final int TRANSACTION_unregisterCallbackListener = 4;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes.dex */
        public static class Proxy implements IMediaSession {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public IBinder mRemote;

            public Proxy(IBinder iBinder) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iBinder};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.mRemote = iBinder;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, mediaDescriptionCompat) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        if (mediaDescriptionCompat != null) {
                            obtain.writeInt(1);
                            mediaDescriptionCompat.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        this.mRemote.transact(41, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void addQueueItemAt(MediaDescriptionCompat mediaDescriptionCompat, int i2) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mediaDescriptionCompat, i2) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        if (mediaDescriptionCompat != null) {
                            obtain.writeInt(1);
                            mediaDescriptionCompat.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        obtain.writeInt(i2);
                        this.mRemote.transact(42, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void adjustVolume(int i2, int i3, String str) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, str) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeInt(i2);
                        obtain.writeInt(i3);
                        obtain.writeString(str);
                        this.mRemote.transact(11, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mRemote : (IBinder) invokeV.objValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void fastForward() throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        this.mRemote.transact(22, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public Bundle getExtras() throws RemoteException {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        this.mRemote.transact(31, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (Bundle) invokeV.objValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public long getFlags() throws RemoteException {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        this.mRemote.transact(9, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readLong();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return invokeV.longValue;
            }

            public String getInterfaceDescriptor() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? Stub.DESCRIPTOR : (String) invokeV.objValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public PendingIntent getLaunchPendingIntent() throws RemoteException {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        this.mRemote.transact(8, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(obtain2) : null;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (PendingIntent) invokeV.objValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public MediaMetadataCompat getMetadata() throws RemoteException {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        this.mRemote.transact(27, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readInt() != 0 ? MediaMetadataCompat.CREATOR.createFromParcel(obtain2) : null;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (MediaMetadataCompat) invokeV.objValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public String getPackageName() throws RemoteException {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        this.mRemote.transact(6, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readString();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (String) invokeV.objValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public PlaybackStateCompat getPlaybackState() throws RemoteException {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        this.mRemote.transact(28, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readInt() != 0 ? PlaybackStateCompat.CREATOR.createFromParcel(obtain2) : null;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (PlaybackStateCompat) invokeV.objValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public List<MediaSessionCompat.QueueItem> getQueue() throws RemoteException {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        this.mRemote.transact(29, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.createTypedArrayList(MediaSessionCompat.QueueItem.CREATOR);
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (List) invokeV.objValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public CharSequence getQueueTitle() throws RemoteException {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        this.mRemote.transact(30, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readInt() != 0 ? (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(obtain2) : null;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (CharSequence) invokeV.objValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getRatingType() throws RemoteException {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        this.mRemote.transact(32, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readInt();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return invokeV.intValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getRepeatMode() throws RemoteException {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        this.mRemote.transact(37, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readInt();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return invokeV.intValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getShuffleMode() throws RemoteException {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        this.mRemote.transact(47, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readInt();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return invokeV.intValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public String getTag() throws RemoteException {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        this.mRemote.transact(7, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readString();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (String) invokeV.objValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public ParcelableVolumeInfo getVolumeAttributes() throws RemoteException {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        this.mRemote.transact(10, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readInt() != 0 ? ParcelableVolumeInfo.CREATOR.createFromParcel(obtain2) : null;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (ParcelableVolumeInfo) invokeV.objValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isCaptioningEnabled() throws RemoteException {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        this.mRemote.transact(45, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readInt() != 0;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return invokeV.booleanValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isShuffleModeEnabledRemoved() throws RemoteException {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        this.mRemote.transact(38, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readInt() != 0;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return invokeV.booleanValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isTransportControlEnabled() throws RemoteException {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        this.mRemote.transact(5, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readInt() != 0;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return invokeV.booleanValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void next() throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        this.mRemote.transact(20, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void pause() throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        this.mRemote.transact(18, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void play() throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        this.mRemote.transact(13, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromMediaId(String str, Bundle bundle) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048601, this, str, bundle) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeString(str);
                        if (bundle != null) {
                            obtain.writeInt(1);
                            bundle.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        this.mRemote.transact(14, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromSearch(String str, Bundle bundle) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048602, this, str, bundle) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeString(str);
                        if (bundle != null) {
                            obtain.writeInt(1);
                            bundle.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        this.mRemote.transact(15, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromUri(Uri uri, Bundle bundle) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048603, this, uri, bundle) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
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
                        this.mRemote.transact(16, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepare() throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        this.mRemote.transact(33, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromMediaId(String str, Bundle bundle) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048605, this, str, bundle) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeString(str);
                        if (bundle != null) {
                            obtain.writeInt(1);
                            bundle.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        this.mRemote.transact(34, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromSearch(String str, Bundle bundle) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048606, this, str, bundle) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeString(str);
                        if (bundle != null) {
                            obtain.writeInt(1);
                            bundle.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        this.mRemote.transact(35, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromUri(Uri uri, Bundle bundle) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048607, this, uri, bundle) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
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
                        this.mRemote.transact(36, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void previous() throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        this.mRemote.transact(21, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rate(RatingCompat ratingCompat) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048609, this, ratingCompat) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        if (ratingCompat != null) {
                            obtain.writeInt(1);
                            ratingCompat.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        this.mRemote.transact(25, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rateWithExtras(RatingCompat ratingCompat, Bundle bundle) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048610, this, ratingCompat, bundle) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        if (ratingCompat != null) {
                            obtain.writeInt(1);
                            ratingCompat.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        if (bundle != null) {
                            obtain.writeInt(1);
                            bundle.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        this.mRemote.transact(51, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void registerCallbackListener(IMediaControllerCallback iMediaControllerCallback) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048611, this, iMediaControllerCallback) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeStrongBinder(iMediaControllerCallback != null ? iMediaControllerCallback.asBinder() : null);
                        this.mRemote.transact(3, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048612, this, mediaDescriptionCompat) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        if (mediaDescriptionCompat != null) {
                            obtain.writeInt(1);
                            mediaDescriptionCompat.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        this.mRemote.transact(43, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void removeQueueItemAt(int i2) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048613, this, i2) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeInt(i2);
                        this.mRemote.transact(44, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rewind() throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        this.mRemote.transact(23, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void seekTo(long j) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeJ(1048615, this, j) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeLong(j);
                        this.mRemote.transact(24, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void sendCommand(String str, Bundle bundle, MediaSessionCompat.ResultReceiverWrapper resultReceiverWrapper) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLLL(1048616, this, str, bundle, resultReceiverWrapper) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeString(str);
                        if (bundle != null) {
                            obtain.writeInt(1);
                            bundle.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        if (resultReceiverWrapper != null) {
                            obtain.writeInt(1);
                            resultReceiverWrapper.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        this.mRemote.transact(1, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void sendCustomAction(String str, Bundle bundle) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(1048617, this, str, bundle) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeString(str);
                        if (bundle != null) {
                            obtain.writeInt(1);
                            bundle.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        this.mRemote.transact(26, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean sendMediaButton(KeyEvent keyEvent) throws RemoteException {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, keyEvent)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        if (keyEvent != null) {
                            obtain.writeInt(1);
                            keyEvent.writeToParcel(obtain, 0);
                        } else {
                            obtain.writeInt(0);
                        }
                        this.mRemote.transact(2, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readInt() != 0;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return invokeL.booleanValue;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setCaptioningEnabled(boolean z) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeInt(z ? 1 : 0);
                        this.mRemote.transact(46, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setRepeatMode(int i2) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048620, this, i2) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeInt(i2);
                        this.mRemote.transact(39, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setShuffleMode(int i2) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048621, this, i2) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeInt(i2);
                        this.mRemote.transact(48, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setShuffleModeEnabledRemoved(boolean z) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(1048622, this, z) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeInt(z ? 1 : 0);
                        this.mRemote.transact(40, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setVolumeTo(int i2, int i3, String str) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIIL(1048623, this, i2, i3, str) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeInt(i2);
                        obtain.writeInt(i3);
                        obtain.writeString(str);
                        this.mRemote.transact(12, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void skipToQueueItem(long j) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeJ(1048624, this, j) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeLong(j);
                        this.mRemote.transact(17, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void stop() throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        this.mRemote.transact(19, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void unregisterCallbackListener(IMediaControllerCallback iMediaControllerCallback) throws RemoteException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048626, this, iMediaControllerCallback) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        obtain.writeStrongBinder(iMediaControllerCallback != null ? iMediaControllerCallback.asBinder() : null);
                        this.mRemote.transact(4, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        obtain2.recycle();
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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

        @Override // android.os.IInterface
        public IBinder asBinder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this : (IBinder) invokeV.objValue;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), parcel, parcel2, Integer.valueOf(i3)})) == null) {
                if (i2 == 51) {
                    parcel.enforceInterface(DESCRIPTOR);
                    rateWithExtras(parcel.readInt() != 0 ? RatingCompat.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                } else if (i2 != 1598968902) {
                    switch (i2) {
                        case 1:
                            parcel.enforceInterface(DESCRIPTOR);
                            sendCommand(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? MediaSessionCompat.ResultReceiverWrapper.CREATOR.createFromParcel(parcel) : null);
                            parcel2.writeNoException();
                            return true;
                        case 2:
                            parcel.enforceInterface(DESCRIPTOR);
                            boolean sendMediaButton = sendMediaButton(parcel.readInt() != 0 ? (KeyEvent) KeyEvent.CREATOR.createFromParcel(parcel) : null);
                            parcel2.writeNoException();
                            parcel2.writeInt(sendMediaButton ? 1 : 0);
                            return true;
                        case 3:
                            parcel.enforceInterface(DESCRIPTOR);
                            registerCallbackListener(IMediaControllerCallback.Stub.asInterface(parcel.readStrongBinder()));
                            parcel2.writeNoException();
                            return true;
                        case 4:
                            parcel.enforceInterface(DESCRIPTOR);
                            unregisterCallbackListener(IMediaControllerCallback.Stub.asInterface(parcel.readStrongBinder()));
                            parcel2.writeNoException();
                            return true;
                        case 5:
                            parcel.enforceInterface(DESCRIPTOR);
                            boolean isTransportControlEnabled = isTransportControlEnabled();
                            parcel2.writeNoException();
                            parcel2.writeInt(isTransportControlEnabled ? 1 : 0);
                            return true;
                        case 6:
                            parcel.enforceInterface(DESCRIPTOR);
                            String packageName = getPackageName();
                            parcel2.writeNoException();
                            parcel2.writeString(packageName);
                            return true;
                        case 7:
                            parcel.enforceInterface(DESCRIPTOR);
                            String tag = getTag();
                            parcel2.writeNoException();
                            parcel2.writeString(tag);
                            return true;
                        case 8:
                            parcel.enforceInterface(DESCRIPTOR);
                            PendingIntent launchPendingIntent = getLaunchPendingIntent();
                            parcel2.writeNoException();
                            if (launchPendingIntent != null) {
                                parcel2.writeInt(1);
                                launchPendingIntent.writeToParcel(parcel2, 1);
                            } else {
                                parcel2.writeInt(0);
                            }
                            return true;
                        case 9:
                            parcel.enforceInterface(DESCRIPTOR);
                            long flags = getFlags();
                            parcel2.writeNoException();
                            parcel2.writeLong(flags);
                            return true;
                        case 10:
                            parcel.enforceInterface(DESCRIPTOR);
                            ParcelableVolumeInfo volumeAttributes = getVolumeAttributes();
                            parcel2.writeNoException();
                            if (volumeAttributes != null) {
                                parcel2.writeInt(1);
                                volumeAttributes.writeToParcel(parcel2, 1);
                            } else {
                                parcel2.writeInt(0);
                            }
                            return true;
                        case 11:
                            parcel.enforceInterface(DESCRIPTOR);
                            adjustVolume(parcel.readInt(), parcel.readInt(), parcel.readString());
                            parcel2.writeNoException();
                            return true;
                        case 12:
                            parcel.enforceInterface(DESCRIPTOR);
                            setVolumeTo(parcel.readInt(), parcel.readInt(), parcel.readString());
                            parcel2.writeNoException();
                            return true;
                        case 13:
                            parcel.enforceInterface(DESCRIPTOR);
                            play();
                            parcel2.writeNoException();
                            return true;
                        case 14:
                            parcel.enforceInterface(DESCRIPTOR);
                            playFromMediaId(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                            parcel2.writeNoException();
                            return true;
                        case 15:
                            parcel.enforceInterface(DESCRIPTOR);
                            playFromSearch(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                            parcel2.writeNoException();
                            return true;
                        case 16:
                            parcel.enforceInterface(DESCRIPTOR);
                            playFromUri(parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                            parcel2.writeNoException();
                            return true;
                        case 17:
                            parcel.enforceInterface(DESCRIPTOR);
                            skipToQueueItem(parcel.readLong());
                            parcel2.writeNoException();
                            return true;
                        case 18:
                            parcel.enforceInterface(DESCRIPTOR);
                            pause();
                            parcel2.writeNoException();
                            return true;
                        case 19:
                            parcel.enforceInterface(DESCRIPTOR);
                            stop();
                            parcel2.writeNoException();
                            return true;
                        case 20:
                            parcel.enforceInterface(DESCRIPTOR);
                            next();
                            parcel2.writeNoException();
                            return true;
                        case 21:
                            parcel.enforceInterface(DESCRIPTOR);
                            previous();
                            parcel2.writeNoException();
                            return true;
                        case 22:
                            parcel.enforceInterface(DESCRIPTOR);
                            fastForward();
                            parcel2.writeNoException();
                            return true;
                        case 23:
                            parcel.enforceInterface(DESCRIPTOR);
                            rewind();
                            parcel2.writeNoException();
                            return true;
                        case 24:
                            parcel.enforceInterface(DESCRIPTOR);
                            seekTo(parcel.readLong());
                            parcel2.writeNoException();
                            return true;
                        case 25:
                            parcel.enforceInterface(DESCRIPTOR);
                            rate(parcel.readInt() != 0 ? RatingCompat.CREATOR.createFromParcel(parcel) : null);
                            parcel2.writeNoException();
                            return true;
                        case 26:
                            parcel.enforceInterface(DESCRIPTOR);
                            sendCustomAction(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                            parcel2.writeNoException();
                            return true;
                        case 27:
                            parcel.enforceInterface(DESCRIPTOR);
                            MediaMetadataCompat metadata = getMetadata();
                            parcel2.writeNoException();
                            if (metadata != null) {
                                parcel2.writeInt(1);
                                metadata.writeToParcel(parcel2, 1);
                            } else {
                                parcel2.writeInt(0);
                            }
                            return true;
                        case 28:
                            parcel.enforceInterface(DESCRIPTOR);
                            PlaybackStateCompat playbackState = getPlaybackState();
                            parcel2.writeNoException();
                            if (playbackState != null) {
                                parcel2.writeInt(1);
                                playbackState.writeToParcel(parcel2, 1);
                            } else {
                                parcel2.writeInt(0);
                            }
                            return true;
                        case 29:
                            parcel.enforceInterface(DESCRIPTOR);
                            List<MediaSessionCompat.QueueItem> queue = getQueue();
                            parcel2.writeNoException();
                            parcel2.writeTypedList(queue);
                            return true;
                        case 30:
                            parcel.enforceInterface(DESCRIPTOR);
                            CharSequence queueTitle = getQueueTitle();
                            parcel2.writeNoException();
                            if (queueTitle != null) {
                                parcel2.writeInt(1);
                                TextUtils.writeToParcel(queueTitle, parcel2, 1);
                            } else {
                                parcel2.writeInt(0);
                            }
                            return true;
                        case 31:
                            parcel.enforceInterface(DESCRIPTOR);
                            Bundle extras = getExtras();
                            parcel2.writeNoException();
                            if (extras != null) {
                                parcel2.writeInt(1);
                                extras.writeToParcel(parcel2, 1);
                            } else {
                                parcel2.writeInt(0);
                            }
                            return true;
                        case 32:
                            parcel.enforceInterface(DESCRIPTOR);
                            int ratingType = getRatingType();
                            parcel2.writeNoException();
                            parcel2.writeInt(ratingType);
                            return true;
                        case 33:
                            parcel.enforceInterface(DESCRIPTOR);
                            prepare();
                            parcel2.writeNoException();
                            return true;
                        case 34:
                            parcel.enforceInterface(DESCRIPTOR);
                            prepareFromMediaId(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                            parcel2.writeNoException();
                            return true;
                        case 35:
                            parcel.enforceInterface(DESCRIPTOR);
                            prepareFromSearch(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                            parcel2.writeNoException();
                            return true;
                        case 36:
                            parcel.enforceInterface(DESCRIPTOR);
                            prepareFromUri(parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                            parcel2.writeNoException();
                            return true;
                        case 37:
                            parcel.enforceInterface(DESCRIPTOR);
                            int repeatMode = getRepeatMode();
                            parcel2.writeNoException();
                            parcel2.writeInt(repeatMode);
                            return true;
                        case 38:
                            parcel.enforceInterface(DESCRIPTOR);
                            boolean isShuffleModeEnabledRemoved = isShuffleModeEnabledRemoved();
                            parcel2.writeNoException();
                            parcel2.writeInt(isShuffleModeEnabledRemoved ? 1 : 0);
                            return true;
                        case 39:
                            parcel.enforceInterface(DESCRIPTOR);
                            setRepeatMode(parcel.readInt());
                            parcel2.writeNoException();
                            return true;
                        case 40:
                            parcel.enforceInterface(DESCRIPTOR);
                            setShuffleModeEnabledRemoved(parcel.readInt() != 0);
                            parcel2.writeNoException();
                            return true;
                        case 41:
                            parcel.enforceInterface(DESCRIPTOR);
                            addQueueItem(parcel.readInt() != 0 ? MediaDescriptionCompat.CREATOR.createFromParcel(parcel) : null);
                            parcel2.writeNoException();
                            return true;
                        case 42:
                            parcel.enforceInterface(DESCRIPTOR);
                            addQueueItemAt(parcel.readInt() != 0 ? MediaDescriptionCompat.CREATOR.createFromParcel(parcel) : null, parcel.readInt());
                            parcel2.writeNoException();
                            return true;
                        case 43:
                            parcel.enforceInterface(DESCRIPTOR);
                            removeQueueItem(parcel.readInt() != 0 ? MediaDescriptionCompat.CREATOR.createFromParcel(parcel) : null);
                            parcel2.writeNoException();
                            return true;
                        case 44:
                            parcel.enforceInterface(DESCRIPTOR);
                            removeQueueItemAt(parcel.readInt());
                            parcel2.writeNoException();
                            return true;
                        case 45:
                            parcel.enforceInterface(DESCRIPTOR);
                            boolean isCaptioningEnabled = isCaptioningEnabled();
                            parcel2.writeNoException();
                            parcel2.writeInt(isCaptioningEnabled ? 1 : 0);
                            return true;
                        case 46:
                            parcel.enforceInterface(DESCRIPTOR);
                            setCaptioningEnabled(parcel.readInt() != 0);
                            parcel2.writeNoException();
                            return true;
                        case 47:
                            parcel.enforceInterface(DESCRIPTOR);
                            int shuffleMode = getShuffleMode();
                            parcel2.writeNoException();
                            parcel2.writeInt(shuffleMode);
                            return true;
                        case 48:
                            parcel.enforceInterface(DESCRIPTOR);
                            setShuffleMode(parcel.readInt());
                            parcel2.writeNoException();
                            return true;
                        default:
                            return super.onTransact(i2, parcel, parcel2, i3);
                    }
                } else {
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                }
            }
            return invokeCommon.booleanValue;
        }
    }

    void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat) throws RemoteException;

    void addQueueItemAt(MediaDescriptionCompat mediaDescriptionCompat, int i2) throws RemoteException;

    void adjustVolume(int i2, int i3, String str) throws RemoteException;

    void fastForward() throws RemoteException;

    Bundle getExtras() throws RemoteException;

    long getFlags() throws RemoteException;

    PendingIntent getLaunchPendingIntent() throws RemoteException;

    MediaMetadataCompat getMetadata() throws RemoteException;

    String getPackageName() throws RemoteException;

    PlaybackStateCompat getPlaybackState() throws RemoteException;

    List<MediaSessionCompat.QueueItem> getQueue() throws RemoteException;

    CharSequence getQueueTitle() throws RemoteException;

    int getRatingType() throws RemoteException;

    int getRepeatMode() throws RemoteException;

    int getShuffleMode() throws RemoteException;

    String getTag() throws RemoteException;

    ParcelableVolumeInfo getVolumeAttributes() throws RemoteException;

    boolean isCaptioningEnabled() throws RemoteException;

    boolean isShuffleModeEnabledRemoved() throws RemoteException;

    boolean isTransportControlEnabled() throws RemoteException;

    void next() throws RemoteException;

    void pause() throws RemoteException;

    void play() throws RemoteException;

    void playFromMediaId(String str, Bundle bundle) throws RemoteException;

    void playFromSearch(String str, Bundle bundle) throws RemoteException;

    void playFromUri(Uri uri, Bundle bundle) throws RemoteException;

    void prepare() throws RemoteException;

    void prepareFromMediaId(String str, Bundle bundle) throws RemoteException;

    void prepareFromSearch(String str, Bundle bundle) throws RemoteException;

    void prepareFromUri(Uri uri, Bundle bundle) throws RemoteException;

    void previous() throws RemoteException;

    void rate(RatingCompat ratingCompat) throws RemoteException;

    void rateWithExtras(RatingCompat ratingCompat, Bundle bundle) throws RemoteException;

    void registerCallbackListener(IMediaControllerCallback iMediaControllerCallback) throws RemoteException;

    void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat) throws RemoteException;

    void removeQueueItemAt(int i2) throws RemoteException;

    void rewind() throws RemoteException;

    void seekTo(long j) throws RemoteException;

    void sendCommand(String str, Bundle bundle, MediaSessionCompat.ResultReceiverWrapper resultReceiverWrapper) throws RemoteException;

    void sendCustomAction(String str, Bundle bundle) throws RemoteException;

    boolean sendMediaButton(KeyEvent keyEvent) throws RemoteException;

    void setCaptioningEnabled(boolean z) throws RemoteException;

    void setRepeatMode(int i2) throws RemoteException;

    void setShuffleMode(int i2) throws RemoteException;

    void setShuffleModeEnabledRemoved(boolean z) throws RemoteException;

    void setVolumeTo(int i2, int i3, String str) throws RemoteException;

    void skipToQueueItem(long j) throws RemoteException;

    void stop() throws RemoteException;

    void unregisterCallbackListener(IMediaControllerCallback iMediaControllerCallback) throws RemoteException;
}

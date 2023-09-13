package com.baidu.cyberplayer.sdk.remote;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.view.Surface;
import com.baidu.cyberplayer.sdk.remote.IRemotePlayerListener;
import java.util.Map;
/* loaded from: classes3.dex */
public interface IRemotePlayer extends IInterface {

    /* loaded from: classes3.dex */
    public static class Default implements IRemotePlayer {
        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
        public void addListener(IRemotePlayerListener iRemotePlayerListener) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
        public void changeProxyDynamic(String str, boolean z) throws RemoteException {
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
        public int getCurrentPosition() throws RemoteException {
            return 0;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
        public int getCurrentPositionSync() throws RemoteException {
            return 0;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
        public int getDecodeMode() throws RemoteException {
            return 0;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
        public long getDownloadSpeed() throws RemoteException {
            return 0L;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
        public int getDuration() throws RemoteException {
            return 0;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
        public void getMediaRuntimeInfo(int i) throws RemoteException {
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
        public long getPlayedTime() throws RemoteException {
            return 0L;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
        public String getPlayerConfigOptions() throws RemoteException {
            return null;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
        public int getVideoHeight() throws RemoteException {
            return 0;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
        public int getVideoWidth() throws RemoteException {
            return 0;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
        public boolean isLooping() throws RemoteException {
            return false;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
        public boolean isPlaying() throws RemoteException {
            return false;
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
        public void muteOrUnmuteAudio(boolean z) throws RemoteException {
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
        public void pause() throws RemoteException {
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
        public void prepareAsync() throws RemoteException {
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
        public void release() throws RemoteException {
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
        public void removeListener(IRemotePlayerListener iRemotePlayerListener) throws RemoteException {
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
        public void reset() throws RemoteException {
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
        public void seekTo(long j, int i) throws RemoteException {
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
        public void sendCommand(int i, int i2, long j, String str) throws RemoteException {
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
        public void setClarityInfo(String str) throws RemoteException {
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
        public void setDataSource(RemoteDataSource remoteDataSource) throws RemoteException {
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
        public void setEnableDumediaUA(boolean z) throws RemoteException {
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
        public void setLooping(boolean z) throws RemoteException {
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
        public void setOption(String str, String str2) throws RemoteException {
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
        public void setOptions(Map map) throws RemoteException {
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
        public void setPlayJson(String str) throws RemoteException {
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
        public void setScreenOnWhilePlaying(boolean z) throws RemoteException {
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
        public void setSpeed(float f) throws RemoteException {
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
        public void setSurface(Surface surface) throws RemoteException {
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
        public void setVolume(float f, float f2) throws RemoteException {
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
        public void setWakeMode(int i) throws RemoteException {
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
        public void start() throws RemoteException {
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
        public void stepToNextFrame() throws RemoteException {
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
        public void stop() throws RemoteException {
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
        public void switchMediaSource(int i, int i2) throws RemoteException {
        }

        @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
        public void updateDisplaySize(int i, int i2) throws RemoteException {
        }
    }

    void addListener(IRemotePlayerListener iRemotePlayerListener) throws RemoteException;

    void changeProxyDynamic(String str, boolean z) throws RemoteException;

    int getCurrentPosition() throws RemoteException;

    int getCurrentPositionSync() throws RemoteException;

    int getDecodeMode() throws RemoteException;

    long getDownloadSpeed() throws RemoteException;

    int getDuration() throws RemoteException;

    void getMediaRuntimeInfo(int i) throws RemoteException;

    long getPlayedTime() throws RemoteException;

    String getPlayerConfigOptions() throws RemoteException;

    int getVideoHeight() throws RemoteException;

    int getVideoWidth() throws RemoteException;

    boolean isLooping() throws RemoteException;

    boolean isPlaying() throws RemoteException;

    void muteOrUnmuteAudio(boolean z) throws RemoteException;

    void pause() throws RemoteException;

    void prepareAsync() throws RemoteException;

    void release() throws RemoteException;

    void removeListener(IRemotePlayerListener iRemotePlayerListener) throws RemoteException;

    void reset() throws RemoteException;

    void seekTo(long j, int i) throws RemoteException;

    void sendCommand(int i, int i2, long j, String str) throws RemoteException;

    void setClarityInfo(String str) throws RemoteException;

    void setDataSource(RemoteDataSource remoteDataSource) throws RemoteException;

    void setEnableDumediaUA(boolean z) throws RemoteException;

    void setLooping(boolean z) throws RemoteException;

    void setOption(String str, String str2) throws RemoteException;

    void setOptions(Map map) throws RemoteException;

    void setPlayJson(String str) throws RemoteException;

    void setScreenOnWhilePlaying(boolean z) throws RemoteException;

    void setSpeed(float f) throws RemoteException;

    void setSurface(Surface surface) throws RemoteException;

    void setVolume(float f, float f2) throws RemoteException;

    void setWakeMode(int i) throws RemoteException;

    void start() throws RemoteException;

    void stepToNextFrame() throws RemoteException;

    void stop() throws RemoteException;

    void switchMediaSource(int i, int i2) throws RemoteException;

    void updateDisplaySize(int i, int i2) throws RemoteException;

    /* loaded from: classes3.dex */
    public static abstract class Stub extends Binder implements IRemotePlayer {
        public static final String DESCRIPTOR = "com.baidu.cyberplayer.sdk.remote.IRemotePlayer";
        public static final int TRANSACTION_addListener = 32;
        public static final int TRANSACTION_changeProxyDynamic = 24;
        public static final int TRANSACTION_getCurrentPosition = 15;
        public static final int TRANSACTION_getCurrentPositionSync = 16;
        public static final int TRANSACTION_getDecodeMode = 1;
        public static final int TRANSACTION_getDownloadSpeed = 30;
        public static final int TRANSACTION_getDuration = 17;
        public static final int TRANSACTION_getMediaRuntimeInfo = 38;
        public static final int TRANSACTION_getPlayedTime = 29;
        public static final int TRANSACTION_getPlayerConfigOptions = 39;
        public static final int TRANSACTION_getVideoHeight = 12;
        public static final int TRANSACTION_getVideoWidth = 11;
        public static final int TRANSACTION_isLooping = 21;
        public static final int TRANSACTION_isPlaying = 13;
        public static final int TRANSACTION_muteOrUnmuteAudio = 31;
        public static final int TRANSACTION_pause = 7;
        public static final int TRANSACTION_prepareAsync = 4;
        public static final int TRANSACTION_release = 18;
        public static final int TRANSACTION_removeListener = 33;
        public static final int TRANSACTION_reset = 19;
        public static final int TRANSACTION_seekTo = 14;
        public static final int TRANSACTION_sendCommand = 27;
        public static final int TRANSACTION_setClarityInfo = 35;
        public static final int TRANSACTION_setDataSource = 3;
        public static final int TRANSACTION_setEnableDumediaUA = 28;
        public static final int TRANSACTION_setLooping = 20;
        public static final int TRANSACTION_setOption = 25;
        public static final int TRANSACTION_setOptions = 26;
        public static final int TRANSACTION_setPlayJson = 36;
        public static final int TRANSACTION_setScreenOnWhilePlaying = 10;
        public static final int TRANSACTION_setSpeed = 23;
        public static final int TRANSACTION_setSurface = 2;
        public static final int TRANSACTION_setVolume = 22;
        public static final int TRANSACTION_setWakeMode = 9;
        public static final int TRANSACTION_start = 5;
        public static final int TRANSACTION_stepToNextFrame = 8;
        public static final int TRANSACTION_stop = 6;
        public static final int TRANSACTION_switchMediaSource = 34;
        public static final int TRANSACTION_updateDisplaySize = 37;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        /* loaded from: classes3.dex */
        public static class Proxy implements IRemotePlayer {
            public static IRemotePlayer sDefaultImpl;
            public IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
            public void addListener(IRemotePlayerListener iRemotePlayerListener) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (iRemotePlayerListener != null) {
                        iBinder = iRemotePlayerListener.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!this.mRemote.transact(32, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().addListener(iRemotePlayerListener);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
            public void removeListener(IRemotePlayerListener iRemotePlayerListener) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (iRemotePlayerListener != null) {
                        iBinder = iRemotePlayerListener.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!this.mRemote.transact(33, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().removeListener(iRemotePlayerListener);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
            public void setDataSource(RemoteDataSource remoteDataSource) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (remoteDataSource != null) {
                        obtain.writeInt(1);
                        remoteDataSource.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setDataSource(remoteDataSource);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
            public void setSurface(Surface surface) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (surface != null) {
                        obtain.writeInt(1);
                        surface.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setSurface(surface);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
            public void changeProxyDynamic(String str, boolean z) throws RemoteException {
                int i;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (z) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(24, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().changeProxyDynamic(str, z);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
            public int getCurrentPosition() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(15, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getCurrentPosition();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
            public int getCurrentPositionSync() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(16, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getCurrentPositionSync();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
            public int getDecodeMode() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDecodeMode();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
            public long getDownloadSpeed() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(30, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDownloadSpeed();
                    }
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
            public int getDuration() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(17, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDuration();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
            public long getPlayedTime() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(29, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getPlayedTime();
                    }
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
            public String getPlayerConfigOptions() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(39, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getPlayerConfigOptions();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
            public int getVideoHeight() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(12, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getVideoHeight();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
            public int getVideoWidth() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(11, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getVideoWidth();
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
            public boolean isLooping() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    if (!this.mRemote.transact(21, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isLooping();
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
            public boolean isPlaying() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    if (!this.mRemote.transact(13, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isPlaying();
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
            public void pause() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().pause();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
            public void prepareAsync() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().prepareAsync();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
            public void release() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(18, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().release();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
            public void reset() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(19, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().reset();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
            public void start() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().start();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
            public void stepToNextFrame() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(8, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().stepToNextFrame();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
            public void stop() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().stop();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
            public void getMediaRuntimeInfo(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(38, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().getMediaRuntimeInfo(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
            public void muteOrUnmuteAudio(boolean z) throws RemoteException {
                int i;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (z) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(31, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().muteOrUnmuteAudio(z);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
            public void setClarityInfo(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(35, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setClarityInfo(str);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
            public void setEnableDumediaUA(boolean z) throws RemoteException {
                int i;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (z) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(28, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setEnableDumediaUA(z);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
            public void setLooping(boolean z) throws RemoteException {
                int i;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (z) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(20, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setLooping(z);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
            public void setOptions(Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeMap(map);
                    if (!this.mRemote.transact(26, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setOptions(map);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
            public void setPlayJson(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(36, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setPlayJson(str);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
            public void setScreenOnWhilePlaying(boolean z) throws RemoteException {
                int i;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (z) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(10, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setScreenOnWhilePlaying(z);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
            public void setSpeed(float f) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeFloat(f);
                    if (!this.mRemote.transact(23, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setSpeed(f);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
            public void setWakeMode(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(9, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setWakeMode(i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
            public void seekTo(long j, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeLong(j);
                    obtain.writeInt(i);
                    if (!this.mRemote.transact(14, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().seekTo(j, i);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
            public void setOption(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.mRemote.transact(25, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setOption(str, str2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
            public void setVolume(float f, float f2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeFloat(f);
                    obtain.writeFloat(f2);
                    if (!this.mRemote.transact(22, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().setVolume(f, f2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
            public void switchMediaSource(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(34, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().switchMediaSource(i, i2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
            public void updateDisplaySize(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (!this.mRemote.transact(37, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().updateDisplaySize(i, i2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.cyberplayer.sdk.remote.IRemotePlayer
            public void sendCommand(int i, int i2, long j, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(27, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().sendCommand(i, i2, j, str);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IRemotePlayer getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IRemotePlayer asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IRemotePlayer)) {
                return (IRemotePlayer) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static boolean setDefaultImpl(IRemotePlayer iRemotePlayer) {
            if (Proxy.sDefaultImpl == null) {
                if (iRemotePlayer != null) {
                    Proxy.sDefaultImpl = iRemotePlayer;
                    return true;
                }
                return false;
            }
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                Surface surface = null;
                RemoteDataSource remoteDataSource = null;
                boolean z = false;
                switch (i) {
                    case 1:
                        parcel.enforceInterface(DESCRIPTOR);
                        int decodeMode = getDecodeMode();
                        parcel2.writeNoException();
                        parcel2.writeInt(decodeMode);
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            surface = (Surface) Surface.CREATOR.createFromParcel(parcel);
                        }
                        setSurface(surface);
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            remoteDataSource = RemoteDataSource.CREATOR.createFromParcel(parcel);
                        }
                        setDataSource(remoteDataSource);
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface(DESCRIPTOR);
                        prepareAsync();
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface(DESCRIPTOR);
                        start();
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface(DESCRIPTOR);
                        stop();
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface(DESCRIPTOR);
                        pause();
                        parcel2.writeNoException();
                        return true;
                    case 8:
                        parcel.enforceInterface(DESCRIPTOR);
                        stepToNextFrame();
                        parcel2.writeNoException();
                        return true;
                    case 9:
                        parcel.enforceInterface(DESCRIPTOR);
                        setWakeMode(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 10:
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        setScreenOnWhilePlaying(z);
                        parcel2.writeNoException();
                        return true;
                    case 11:
                        parcel.enforceInterface(DESCRIPTOR);
                        int videoWidth = getVideoWidth();
                        parcel2.writeNoException();
                        parcel2.writeInt(videoWidth);
                        return true;
                    case 12:
                        parcel.enforceInterface(DESCRIPTOR);
                        int videoHeight = getVideoHeight();
                        parcel2.writeNoException();
                        parcel2.writeInt(videoHeight);
                        return true;
                    case 13:
                        parcel.enforceInterface(DESCRIPTOR);
                        boolean isPlaying = isPlaying();
                        parcel2.writeNoException();
                        parcel2.writeInt(isPlaying ? 1 : 0);
                        return true;
                    case 14:
                        parcel.enforceInterface(DESCRIPTOR);
                        seekTo(parcel.readLong(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 15:
                        parcel.enforceInterface(DESCRIPTOR);
                        int currentPosition = getCurrentPosition();
                        parcel2.writeNoException();
                        parcel2.writeInt(currentPosition);
                        return true;
                    case 16:
                        parcel.enforceInterface(DESCRIPTOR);
                        int currentPositionSync = getCurrentPositionSync();
                        parcel2.writeNoException();
                        parcel2.writeInt(currentPositionSync);
                        return true;
                    case 17:
                        parcel.enforceInterface(DESCRIPTOR);
                        int duration = getDuration();
                        parcel2.writeNoException();
                        parcel2.writeInt(duration);
                        return true;
                    case 18:
                        parcel.enforceInterface(DESCRIPTOR);
                        release();
                        parcel2.writeNoException();
                        return true;
                    case 19:
                        parcel.enforceInterface(DESCRIPTOR);
                        reset();
                        parcel2.writeNoException();
                        return true;
                    case 20:
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        setLooping(z);
                        parcel2.writeNoException();
                        return true;
                    case 21:
                        parcel.enforceInterface(DESCRIPTOR);
                        boolean isLooping = isLooping();
                        parcel2.writeNoException();
                        parcel2.writeInt(isLooping ? 1 : 0);
                        return true;
                    case 22:
                        parcel.enforceInterface(DESCRIPTOR);
                        setVolume(parcel.readFloat(), parcel.readFloat());
                        parcel2.writeNoException();
                        return true;
                    case 23:
                        parcel.enforceInterface(DESCRIPTOR);
                        setSpeed(parcel.readFloat());
                        parcel2.writeNoException();
                        return true;
                    case 24:
                        parcel.enforceInterface(DESCRIPTOR);
                        String readString = parcel.readString();
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        changeProxyDynamic(readString, z);
                        parcel2.writeNoException();
                        return true;
                    case 25:
                        parcel.enforceInterface(DESCRIPTOR);
                        setOption(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 26:
                        parcel.enforceInterface(DESCRIPTOR);
                        setOptions(parcel.readHashMap(getClass().getClassLoader()));
                        parcel2.writeNoException();
                        return true;
                    case 27:
                        parcel.enforceInterface(DESCRIPTOR);
                        sendCommand(parcel.readInt(), parcel.readInt(), parcel.readLong(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 28:
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        setEnableDumediaUA(z);
                        parcel2.writeNoException();
                        return true;
                    case 29:
                        parcel.enforceInterface(DESCRIPTOR);
                        long playedTime = getPlayedTime();
                        parcel2.writeNoException();
                        parcel2.writeLong(playedTime);
                        return true;
                    case 30:
                        parcel.enforceInterface(DESCRIPTOR);
                        long downloadSpeed = getDownloadSpeed();
                        parcel2.writeNoException();
                        parcel2.writeLong(downloadSpeed);
                        return true;
                    case 31:
                        parcel.enforceInterface(DESCRIPTOR);
                        if (parcel.readInt() != 0) {
                            z = true;
                        }
                        muteOrUnmuteAudio(z);
                        parcel2.writeNoException();
                        return true;
                    case 32:
                        parcel.enforceInterface(DESCRIPTOR);
                        addListener(IRemotePlayerListener.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 33:
                        parcel.enforceInterface(DESCRIPTOR);
                        removeListener(IRemotePlayerListener.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 34:
                        parcel.enforceInterface(DESCRIPTOR);
                        switchMediaSource(parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 35:
                        parcel.enforceInterface(DESCRIPTOR);
                        setClarityInfo(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 36:
                        parcel.enforceInterface(DESCRIPTOR);
                        setPlayJson(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 37:
                        parcel.enforceInterface(DESCRIPTOR);
                        updateDisplaySize(parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 38:
                        parcel.enforceInterface(DESCRIPTOR);
                        getMediaRuntimeInfo(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 39:
                        parcel.enforceInterface(DESCRIPTOR);
                        String playerConfigOptions = getPlayerConfigOptions();
                        parcel2.writeNoException();
                        parcel2.writeString(playerConfigOptions);
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            }
            parcel2.writeString(DESCRIPTOR);
            return true;
        }
    }
}

package com.asus.msa.sdid;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.annotation.Keep;
import com.asus.msa.SupplementaryDID.IDidAidlInterface;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Keep
/* loaded from: classes.dex */
public interface IDIDBinderStatusListener extends IInterface {

    @Keep
    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IDIDBinderStatusListener {
        public static /* synthetic */ Interceptable $ic = null;
        @Keep
        public static final String DESCRIPTOR = "com.asus.msa.sdid.IDIDBinderStatusListener";
        @Keep
        public static final int TRANSACTION_onError = 2;
        @Keep
        public static final int TRANSACTION_onSuccess = 1;
        public transient /* synthetic */ FieldHolder $fh;

        @Keep
        /* loaded from: classes.dex */
        public static class Proxy implements IDIDBinderStatusListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            @Keep
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

            @Override // android.os.IInterface
            @Keep
            public native IBinder asBinder();

            @Keep
            public native String getInterfaceDescriptor();

            @Override // com.asus.msa.sdid.IDIDBinderStatusListener
            @Keep
            public native void onError();

            @Override // com.asus.msa.sdid.IDIDBinderStatusListener
            @Keep
            public native void onSuccess(IDidAidlInterface iDidAidlInterface);
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

        @Keep
        public static native IDIDBinderStatusListener asInterface(IBinder iBinder);

        @Override // android.os.IInterface
        @Keep
        public native IBinder asBinder();

        @Override // android.os.Binder
        @Keep
        public native boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2);
    }

    @Keep
    void onError();

    @Keep
    void onSuccess(IDidAidlInterface iDidAidlInterface);
}

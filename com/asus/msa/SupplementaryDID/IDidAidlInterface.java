package com.asus.msa.SupplementaryDID;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.annotation.Keep;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Keep
/* loaded from: classes.dex */
public interface IDidAidlInterface extends IInterface {

    @Keep
    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IDidAidlInterface {
        public static /* synthetic */ Interceptable $ic = null;
        @Keep
        public static final String DESCRIPTOR = "com.asus.msa.SupplementaryDID.IDidAidlInterface";
        @Keep
        public static final int TRANSACTION_getAAID = 5;
        @Keep
        public static final int TRANSACTION_getOAID = 3;
        @Keep
        public static final int TRANSACTION_getUDID = 2;
        @Keep
        public static final int TRANSACTION_getVAID = 4;
        @Keep
        public static final int TRANSACTION_isSupport = 1;
        public transient /* synthetic */ FieldHolder $fh;

        @Keep
        /* loaded from: classes.dex */
        public static class Proxy implements IDidAidlInterface {
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

            @Override // com.asus.msa.SupplementaryDID.IDidAidlInterface
            @Keep
            public native String getAAID();

            @Keep
            public native String getInterfaceDescriptor();

            @Override // com.asus.msa.SupplementaryDID.IDidAidlInterface
            @Keep
            public native String getOAID();

            @Override // com.asus.msa.SupplementaryDID.IDidAidlInterface
            @Keep
            public native String getUDID();

            @Override // com.asus.msa.SupplementaryDID.IDidAidlInterface
            @Keep
            public native String getVAID();

            @Override // com.asus.msa.SupplementaryDID.IDidAidlInterface
            @Keep
            public native boolean isSupport();
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
        public static native IDidAidlInterface asInterface(IBinder iBinder);

        @Override // android.os.IInterface
        @Keep
        public native IBinder asBinder();

        @Override // android.os.Binder
        @Keep
        public native boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2);
    }

    @Keep
    String getAAID();

    @Keep
    String getOAID();

    @Keep
    String getUDID();

    @Keep
    String getVAID();

    @Keep
    boolean isSupport();
}

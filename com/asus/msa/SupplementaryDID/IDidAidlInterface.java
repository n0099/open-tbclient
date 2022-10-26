package com.asus.msa.SupplementaryDID;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public interface IDidAidlInterface extends IInterface {

    /* loaded from: classes.dex */
    public abstract class Stub extends Binder implements IDidAidlInterface {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String DESCRIPTOR = "com.asus.msa.SupplementaryDID.IDidAidlInterface";
        public static final int TRANSACTION_getAAID = 5;
        public static final int TRANSACTION_getOAID = 3;
        public static final int TRANSACTION_getUDID = 2;
        public static final int TRANSACTION_getVAID = 4;
        public static final int TRANSACTION_isSupport = 1;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes.dex */
        public class Proxy implements IDidAidlInterface {
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
            public native IBinder asBinder();

            @Override // com.asus.msa.SupplementaryDID.IDidAidlInterface
            public native String getAAID();

            public native String getInterfaceDescriptor();

            @Override // com.asus.msa.SupplementaryDID.IDidAidlInterface
            public native String getOAID();

            @Override // com.asus.msa.SupplementaryDID.IDidAidlInterface
            public native String getUDID();

            @Override // com.asus.msa.SupplementaryDID.IDidAidlInterface
            public native String getVAID();

            @Override // com.asus.msa.SupplementaryDID.IDidAidlInterface
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

        public static native IDidAidlInterface asInterface(IBinder iBinder);

        @Override // android.os.IInterface
        public native IBinder asBinder();

        @Override // android.os.Binder
        public native boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2);
    }

    String getAAID();

    String getOAID();

    String getUDID();

    String getVAID();

    boolean isSupport();
}

package androidx.media2.common;

import android.annotation.SuppressLint;
import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.ParcelImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"BanParcelableUsage"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class ParcelImplListSlice implements Parcelable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Parcelable.Creator<ParcelImplListSlice> CREATOR;
    public static final boolean DEBUG = false;
    public static final int MAX_IPC_SIZE = 65536;
    public static final String TAG = "ParcelImplListSlice";
    public transient /* synthetic */ FieldHolder $fh;
    public final List<ParcelImpl> mList;

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(925034989, "Landroidx/media2/common/ParcelImplListSlice;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(925034989, "Landroidx/media2/common/ParcelImplListSlice;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<ParcelImplListSlice>() { // from class: androidx.media2.common.ParcelImplListSlice.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ParcelImplListSlice createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                    return new ParcelImplListSlice(parcel);
                }
                return (ParcelImplListSlice) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ParcelImplListSlice[] newArray(int i) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                    return new ParcelImplListSlice[i];
                }
                return (ParcelImplListSlice[]) invokeI.objValue;
            }
        };
    }

    @NonNull
    public List<ParcelImpl> getList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mList;
        }
        return (List) invokeV.objValue;
    }

    public ParcelImplListSlice(Parcel parcel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        int readInt = parcel.readInt();
        this.mList = new ArrayList(readInt);
        if (readInt <= 0) {
            return;
        }
        int i3 = 0;
        while (i3 < readInt && parcel.readInt() != 0) {
            this.mList.add((ParcelImpl) parcel.readParcelable(ParcelImpl.class.getClassLoader()));
            i3++;
        }
        if (i3 >= readInt) {
            return;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        while (i3 < readInt) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInt(i3);
                readStrongBinder.transact(1, obtain, obtain2, 0);
                while (i3 < readInt && obtain2.readInt() != 0) {
                    this.mList.add((ParcelImpl) obtain2.readParcelable(ParcelImpl.class.getClassLoader()));
                    i3++;
                }
            } catch (RemoteException e) {
                Log.w(TAG, "Failure retrieving array; only received " + i3 + " of " + readInt, e);
                return;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    public ParcelImplListSlice(@NonNull List<ParcelImpl> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        if (list != null) {
            this.mList = list;
            return;
        }
        throw new NullPointerException("list shouldn't be null");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, parcel, i) == null) {
            int size = this.mList.size();
            parcel.writeInt(size);
            if (size > 0) {
                int i2 = 0;
                while (i2 < size && parcel.dataSize() < 65536) {
                    parcel.writeInt(1);
                    parcel.writeParcelable(this.mList.get(i2), i);
                    i2++;
                }
                if (i2 < size) {
                    parcel.writeInt(0);
                    parcel.writeStrongBinder(new Binder(this, size) { // from class: androidx.media2.common.ParcelImplListSlice.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ ParcelImplListSlice this$0;
                        public final /* synthetic */ int val$itemCount;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, Integer.valueOf(size)};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$itemCount = size;
                        }

                        @Override // android.os.Binder
                        public boolean onTransact(int i3, Parcel parcel2, Parcel parcel3, int i4) throws RemoteException {
                            InterceptResult invokeCommon;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeCommon = interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i3), parcel2, parcel3, Integer.valueOf(i4)})) == null) {
                                if (i3 != 1) {
                                    return super.onTransact(i3, parcel2, parcel3, i4);
                                }
                                int readInt = parcel2.readInt();
                                while (readInt < this.val$itemCount && parcel3.dataSize() < 65536) {
                                    parcel3.writeInt(1);
                                    parcel3.writeParcelable(this.this$0.mList.get(readInt), i4);
                                    readInt++;
                                }
                                if (readInt < this.val$itemCount) {
                                    parcel3.writeInt(0);
                                }
                                return true;
                            }
                            return invokeCommon.booleanValue;
                        }
                    });
                }
            }
        }
    }
}

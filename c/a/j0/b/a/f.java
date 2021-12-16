package c.a.j0.b.a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FileDescriptor;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes.dex */
public abstract class f implements IBinder, IBinder.DeathRecipient {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public volatile IBinder f3729e;

    /* renamed from: f  reason: collision with root package name */
    public HashSet<IBinder.DeathRecipient> f3730f;

    /* renamed from: g  reason: collision with root package name */
    public Object f3731g;

    public f() {
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
        this.f3730f = new HashSet<>();
        this.f3731g = new Object();
    }

    public static void b(String str, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, exc) == null) {
        }
    }

    public final IBinder a() throws RemoteException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this.f3731g) {
                IBinder iBinder = this.f3729e;
                if (iBinder != null) {
                    return iBinder;
                }
                IBinder c2 = c();
                this.f3729e = c2;
                if (c2 != null) {
                    c2.linkToDeath(this, 0);
                    return c2;
                }
                throw new RemoteException();
            }
        }
        return (IBinder) invokeV.objValue;
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this.f3731g) {
                IBinder iBinder = this.f3729e;
                if (iBinder != null) {
                    iBinder.unlinkToDeath(this, 0);
                    this.f3729e = null;
                }
                ArrayList<IBinder.DeathRecipient> arrayList = new ArrayList();
                synchronized (this.f3730f) {
                    arrayList.addAll(this.f3730f);
                }
                for (IBinder.DeathRecipient deathRecipient : arrayList) {
                    deathRecipient.binderDied();
                }
            }
        }
    }

    public abstract IBinder c() throws RemoteException;

    @Override // android.os.IBinder
    public void dump(FileDescriptor fileDescriptor, String[] strArr) throws RemoteException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, fileDescriptor, strArr) == null) {
            a().dump(fileDescriptor, strArr);
        }
    }

    @Override // android.os.IBinder
    public void dumpAsync(FileDescriptor fileDescriptor, String[] strArr) throws RemoteException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, fileDescriptor, strArr) == null) {
            a().dumpAsync(fileDescriptor, strArr);
        }
    }

    @Override // android.os.IBinder
    public String getInterfaceDescriptor() throws RemoteException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? a().getInterfaceDescriptor() : (String) invokeV.objValue;
    }

    @Override // android.os.IBinder
    public boolean isBinderAlive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            try {
                return a().isBinderAlive();
            } catch (RemoteException e2) {
                b("MultiProcess", e2);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // android.os.IBinder
    public void linkToDeath(IBinder.DeathRecipient deathRecipient, int i2) throws RemoteException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, deathRecipient, i2) == null) {
            synchronized (this.f3730f) {
                this.f3730f.add(deathRecipient);
            }
        }
    }

    @Override // android.os.IBinder
    public boolean pingBinder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            try {
                return a().pingBinder();
            } catch (RemoteException e2) {
                b("MultiProcess", e2);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // android.os.IBinder
    public IInterface queryLocalInterface(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            try {
                return a().queryLocalInterface(str);
            } catch (RemoteException e2) {
                b("MultiProcess", e2);
                return null;
            }
        }
        return (IInterface) invokeL.objValue;
    }

    @Override // android.os.IBinder
    public boolean transact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i2), parcel, parcel2, Integer.valueOf(i3)})) == null) ? a().transact(i2, parcel, parcel2, i3) : invokeCommon.booleanValue;
    }

    @Override // android.os.IBinder
    public boolean unlinkToDeath(IBinder.DeathRecipient deathRecipient, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048587, this, deathRecipient, i2)) == null) {
            synchronized (this.f3730f) {
                this.f3730f.remove(deathRecipient);
            }
            return this.f3729e != null;
        }
        return invokeLI.booleanValue;
    }
}

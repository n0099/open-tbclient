package com.baidu.swan.support.v4.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.be4;
import com.repackage.de4;
/* loaded from: classes2.dex */
public final class FragmentState implements Parcelable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<FragmentState> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public final Bundle mArguments;
    public final String mClassName;
    public final int mContainerId;
    public final boolean mDetached;
    public final int mFragmentId;
    public final boolean mFromLayout;
    public final int mIndex;
    public Fragment mInstance;
    public final boolean mRetainInstance;
    public Bundle mSavedFragmentState;
    public final String mTag;

    /* loaded from: classes2.dex */
    public static class a implements Parcelable.Creator<FragmentState> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public FragmentState createFromParcel(Parcel parcel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) ? new FragmentState(parcel) : (FragmentState) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public FragmentState[] newArray(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? new FragmentState[i] : (FragmentState[]) invokeI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-614342007, "Lcom/baidu/swan/support/v4/app/FragmentState;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-614342007, "Lcom/baidu/swan/support/v4/app/FragmentState;");
                return;
            }
        }
        CREATOR = new a();
    }

    public FragmentState(Fragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fragment};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mClassName = fragment.getClass().getName();
        this.mIndex = fragment.f;
        this.mFromLayout = fragment.o;
        this.mFragmentId = fragment.w;
        this.mContainerId = fragment.x;
        this.mTag = fragment.y;
        this.mRetainInstance = fragment.B;
        this.mDetached = fragment.A;
        this.mArguments = fragment.h;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public Fragment instantiate(be4 be4Var, Fragment fragment) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, be4Var, fragment)) == null) {
            Fragment fragment2 = this.mInstance;
            if (fragment2 != null) {
                return fragment2;
            }
            Context context = be4Var.getContext();
            Bundle bundle = this.mArguments;
            if (bundle != null) {
                bundle.setClassLoader(context.getClassLoader());
            }
            this.mInstance = Fragment.d0(context, this.mClassName, this.mArguments);
            Bundle bundle2 = this.mSavedFragmentState;
            if (bundle2 != null) {
                bundle2.setClassLoader(context.getClassLoader());
                this.mInstance.d = this.mSavedFragmentState;
            }
            this.mInstance.k1(this.mIndex, fragment);
            Fragment fragment3 = this.mInstance;
            fragment3.o = this.mFromLayout;
            fragment3.q = true;
            fragment3.w = this.mFragmentId;
            fragment3.x = this.mContainerId;
            fragment3.y = this.mTag;
            fragment3.B = this.mRetainInstance;
            fragment3.A = this.mDetached;
            fragment3.s = be4Var.e;
            if (de4.x) {
                Log.v("FragmentManager", "Instantiated fragment " + this.mInstance);
            }
            return this.mInstance;
        }
        return (Fragment) invokeLL.objValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, parcel, i) == null) {
            parcel.writeString(this.mClassName);
            parcel.writeInt(this.mIndex);
            parcel.writeInt(this.mFromLayout ? 1 : 0);
            parcel.writeInt(this.mFragmentId);
            parcel.writeInt(this.mContainerId);
            parcel.writeString(this.mTag);
            parcel.writeInt(this.mRetainInstance ? 1 : 0);
            parcel.writeInt(this.mDetached ? 1 : 0);
            parcel.writeBundle(this.mArguments);
            parcel.writeBundle(this.mSavedFragmentState);
        }
    }

    public FragmentState(Parcel parcel) {
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
        this.mClassName = parcel.readString();
        this.mIndex = parcel.readInt();
        this.mFromLayout = parcel.readInt() != 0;
        this.mFragmentId = parcel.readInt();
        this.mContainerId = parcel.readInt();
        this.mTag = parcel.readString();
        this.mRetainInstance = parcel.readInt() != 0;
        this.mDetached = parcel.readInt() != 0;
        this.mArguments = parcel.readBundle();
        this.mSavedFragmentState = parcel.readBundle();
    }
}

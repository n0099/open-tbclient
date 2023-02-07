package com.baidu.swan.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.lm4;
import com.baidu.tieba.tm4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public final class BackStackState implements Parcelable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<BackStackState> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public final int mBreadCrumbShortTitleRes;
    public final CharSequence mBreadCrumbShortTitleText;
    public final int mBreadCrumbTitleRes;
    public final CharSequence mBreadCrumbTitleText;
    public final int mIndex;
    public final String mName;
    public final int[] mOps;
    public final ArrayList<String> mSharedElementSourceNames;
    public final ArrayList<String> mSharedElementTargetNames;
    public final int mTransition;
    public final int mTransitionStyle;

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes3.dex */
    public static class a implements Parcelable.Creator<BackStackState> {
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
        public BackStackState createFromParcel(Parcel parcel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) {
                return new BackStackState(parcel);
            }
            return (BackStackState) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public BackStackState[] newArray(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                return new BackStackState[i];
            }
            return (BackStackState[]) invokeI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1485972836, "Lcom/baidu/swan/support/v4/app/BackStackState;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1485972836, "Lcom/baidu/swan/support/v4/app/BackStackState;");
                return;
            }
        }
        CREATOR = new a();
    }

    public BackStackState(Parcel parcel) {
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
        this.mOps = parcel.createIntArray();
        this.mTransition = parcel.readInt();
        this.mTransitionStyle = parcel.readInt();
        this.mName = parcel.readString();
        this.mIndex = parcel.readInt();
        this.mBreadCrumbTitleRes = parcel.readInt();
        this.mBreadCrumbTitleText = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mBreadCrumbShortTitleRes = parcel.readInt();
        this.mBreadCrumbShortTitleText = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mSharedElementSourceNames = parcel.createStringArrayList();
        this.mSharedElementTargetNames = parcel.createStringArrayList();
    }

    public BackStackState(lm4 lm4Var) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lm4Var};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        int i4 = 0;
        for (lm4.d dVar = lm4Var.b; dVar != null; dVar = dVar.a) {
            ArrayList<Fragment> arrayList = dVar.i;
            if (arrayList != null) {
                i4 += arrayList.size();
            }
        }
        this.mOps = new int[(lm4Var.d * 7) + i4];
        if (lm4Var.k) {
            int i5 = 0;
            for (lm4.d dVar2 = lm4Var.b; dVar2 != null; dVar2 = dVar2.a) {
                int[] iArr = this.mOps;
                int i6 = i5 + 1;
                iArr[i5] = dVar2.c;
                int i7 = i6 + 1;
                Fragment fragment = dVar2.d;
                if (fragment != null) {
                    i = fragment.f;
                } else {
                    i = -1;
                }
                iArr[i6] = i;
                int[] iArr2 = this.mOps;
                int i8 = i7 + 1;
                iArr2[i7] = dVar2.e;
                int i9 = i8 + 1;
                iArr2[i8] = dVar2.f;
                int i10 = i9 + 1;
                iArr2[i9] = dVar2.g;
                int i11 = i10 + 1;
                iArr2[i10] = dVar2.h;
                ArrayList<Fragment> arrayList2 = dVar2.i;
                if (arrayList2 != null) {
                    int size = arrayList2.size();
                    int i12 = i11 + 1;
                    this.mOps[i11] = size;
                    int i13 = 0;
                    while (i13 < size) {
                        this.mOps[i12] = dVar2.i.get(i13).f;
                        i13++;
                        i12++;
                    }
                    i5 = i12;
                } else {
                    iArr2[i11] = 0;
                    i5 = i11 + 1;
                }
            }
            this.mTransition = lm4Var.i;
            this.mTransitionStyle = lm4Var.j;
            this.mName = lm4Var.m;
            this.mIndex = lm4Var.o;
            this.mBreadCrumbTitleRes = lm4Var.p;
            this.mBreadCrumbTitleText = lm4Var.q;
            this.mBreadCrumbShortTitleRes = lm4Var.r;
            this.mBreadCrumbShortTitleText = lm4Var.s;
            this.mSharedElementSourceNames = lm4Var.t;
            this.mSharedElementTargetNames = lm4Var.u;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    public lm4 instantiate(tm4 tm4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tm4Var)) == null) {
            lm4 lm4Var = new lm4(tm4Var);
            int i = 0;
            int i2 = 0;
            while (i < this.mOps.length) {
                lm4.d dVar = new lm4.d();
                int i3 = i + 1;
                dVar.c = this.mOps[i];
                if (tm4.x) {
                    Log.v("FragmentManager", "Instantiate " + lm4Var + " op #" + i2 + " base fragment #" + this.mOps[i3]);
                }
                int i4 = i3 + 1;
                int i5 = this.mOps[i3];
                if (i5 >= 0) {
                    dVar.d = tm4Var.d.get(i5);
                } else {
                    dVar.d = null;
                }
                int[] iArr = this.mOps;
                int i6 = i4 + 1;
                dVar.e = iArr[i4];
                int i7 = i6 + 1;
                dVar.f = iArr[i6];
                int i8 = i7 + 1;
                dVar.g = iArr[i7];
                int i9 = i8 + 1;
                dVar.h = iArr[i8];
                int i10 = i9 + 1;
                int i11 = iArr[i9];
                if (i11 > 0) {
                    dVar.i = new ArrayList<>(i11);
                    int i12 = 0;
                    while (i12 < i11) {
                        if (tm4.x) {
                            Log.v("FragmentManager", "Instantiate " + lm4Var + " set remove fragment #" + this.mOps[i10]);
                        }
                        dVar.i.add(tm4Var.d.get(this.mOps[i10]));
                        i12++;
                        i10++;
                    }
                }
                i = i10;
                lm4Var.o(dVar);
                i2++;
            }
            lm4Var.i = this.mTransition;
            lm4Var.j = this.mTransitionStyle;
            lm4Var.m = this.mName;
            lm4Var.o = this.mIndex;
            lm4Var.k = true;
            lm4Var.p = this.mBreadCrumbTitleRes;
            lm4Var.q = this.mBreadCrumbTitleText;
            lm4Var.r = this.mBreadCrumbShortTitleRes;
            lm4Var.s = this.mBreadCrumbShortTitleText;
            lm4Var.t = this.mSharedElementSourceNames;
            lm4Var.u = this.mSharedElementTargetNames;
            lm4Var.q(1);
            return lm4Var;
        }
        return (lm4) invokeL.objValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, parcel, i) == null) {
            parcel.writeIntArray(this.mOps);
            parcel.writeInt(this.mTransition);
            parcel.writeInt(this.mTransitionStyle);
            parcel.writeString(this.mName);
            parcel.writeInt(this.mIndex);
            parcel.writeInt(this.mBreadCrumbTitleRes);
            TextUtils.writeToParcel(this.mBreadCrumbTitleText, parcel, 0);
            parcel.writeInt(this.mBreadCrumbShortTitleRes);
            TextUtils.writeToParcel(this.mBreadCrumbShortTitleText, parcel, 0);
            parcel.writeStringList(this.mSharedElementSourceNames);
            parcel.writeStringList(this.mSharedElementTargetNames);
        }
    }
}

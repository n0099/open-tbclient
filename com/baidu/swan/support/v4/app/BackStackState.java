package com.baidu.swan.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ne4;
import com.baidu.tieba.ve4;
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
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) ? new BackStackState(parcel) : (BackStackState) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public BackStackState[] newArray(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? new BackStackState[i] : (BackStackState[]) invokeI.objValue;
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

    public BackStackState(ne4 ne4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ne4Var};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        int i3 = 0;
        for (ne4.d dVar = ne4Var.b; dVar != null; dVar = dVar.a) {
            ArrayList<Fragment> arrayList = dVar.i;
            if (arrayList != null) {
                i3 += arrayList.size();
            }
        }
        this.mOps = new int[(ne4Var.d * 7) + i3];
        if (ne4Var.k) {
            int i4 = 0;
            for (ne4.d dVar2 = ne4Var.b; dVar2 != null; dVar2 = dVar2.a) {
                int[] iArr = this.mOps;
                int i5 = i4 + 1;
                iArr[i4] = dVar2.c;
                int i6 = i5 + 1;
                Fragment fragment = dVar2.d;
                iArr[i5] = fragment != null ? fragment.f : -1;
                int[] iArr2 = this.mOps;
                int i7 = i6 + 1;
                iArr2[i6] = dVar2.e;
                int i8 = i7 + 1;
                iArr2[i7] = dVar2.f;
                int i9 = i8 + 1;
                iArr2[i8] = dVar2.g;
                int i10 = i9 + 1;
                iArr2[i9] = dVar2.h;
                ArrayList<Fragment> arrayList2 = dVar2.i;
                if (arrayList2 != null) {
                    int size = arrayList2.size();
                    int i11 = i10 + 1;
                    this.mOps[i10] = size;
                    int i12 = 0;
                    while (i12 < size) {
                        this.mOps[i11] = dVar2.i.get(i12).f;
                        i12++;
                        i11++;
                    }
                    i4 = i11;
                } else {
                    iArr2[i10] = 0;
                    i4 = i10 + 1;
                }
            }
            this.mTransition = ne4Var.i;
            this.mTransitionStyle = ne4Var.j;
            this.mName = ne4Var.m;
            this.mIndex = ne4Var.o;
            this.mBreadCrumbTitleRes = ne4Var.p;
            this.mBreadCrumbTitleText = ne4Var.q;
            this.mBreadCrumbShortTitleRes = ne4Var.r;
            this.mBreadCrumbShortTitleText = ne4Var.s;
            this.mSharedElementSourceNames = ne4Var.t;
            this.mSharedElementTargetNames = ne4Var.u;
            return;
        }
        throw new IllegalStateException("Not on back stack");
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

    public ne4 instantiate(ve4 ve4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ve4Var)) == null) {
            ne4 ne4Var = new ne4(ve4Var);
            int i = 0;
            int i2 = 0;
            while (i < this.mOps.length) {
                ne4.d dVar = new ne4.d();
                int i3 = i + 1;
                dVar.c = this.mOps[i];
                if (ve4.x) {
                    Log.v("FragmentManager", "Instantiate " + ne4Var + " op #" + i2 + " base fragment #" + this.mOps[i3]);
                }
                int i4 = i3 + 1;
                int i5 = this.mOps[i3];
                if (i5 >= 0) {
                    dVar.d = ve4Var.d.get(i5);
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
                        if (ve4.x) {
                            Log.v("FragmentManager", "Instantiate " + ne4Var + " set remove fragment #" + this.mOps[i10]);
                        }
                        dVar.i.add(ve4Var.d.get(this.mOps[i10]));
                        i12++;
                        i10++;
                    }
                }
                i = i10;
                ne4Var.o(dVar);
                i2++;
            }
            ne4Var.i = this.mTransition;
            ne4Var.j = this.mTransitionStyle;
            ne4Var.m = this.mName;
            ne4Var.o = this.mIndex;
            ne4Var.k = true;
            ne4Var.p = this.mBreadCrumbTitleRes;
            ne4Var.q = this.mBreadCrumbTitleText;
            ne4Var.r = this.mBreadCrumbShortTitleRes;
            ne4Var.s = this.mBreadCrumbShortTitleText;
            ne4Var.t = this.mSharedElementSourceNames;
            ne4Var.u = this.mSharedElementTargetNames;
            ne4Var.q(1);
            return ne4Var;
        }
        return (ne4) invokeL.objValue;
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
}

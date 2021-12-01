package com.baidu.swan.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import c.a.p0.r.a.a.f;
import c.a.p0.r.a.a.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes9.dex */
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

    /* loaded from: classes9.dex */
    public static class a implements Parcelable.Creator<BackStackState> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
        public BackStackState[] newArray(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? new BackStackState[i2] : (BackStackState[]) invokeI.objValue;
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

    public BackStackState(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
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
        for (f.d dVar = fVar.f10870f; dVar != null; dVar = dVar.a) {
            ArrayList<Fragment> arrayList = dVar.f10895i;
            if (arrayList != null) {
                i4 += arrayList.size();
            }
        }
        this.mOps = new int[(fVar.f10872h * 7) + i4];
        if (fVar.o) {
            int i5 = 0;
            for (f.d dVar2 = fVar.f10870f; dVar2 != null; dVar2 = dVar2.a) {
                int[] iArr = this.mOps;
                int i6 = i5 + 1;
                iArr[i5] = dVar2.f10889c;
                int i7 = i6 + 1;
                Fragment fragment = dVar2.f10890d;
                iArr[i6] = fragment != null ? fragment.f40710j : -1;
                int[] iArr2 = this.mOps;
                int i8 = i7 + 1;
                iArr2[i7] = dVar2.f10891e;
                int i9 = i8 + 1;
                iArr2[i8] = dVar2.f10892f;
                int i10 = i9 + 1;
                iArr2[i9] = dVar2.f10893g;
                int i11 = i10 + 1;
                iArr2[i10] = dVar2.f10894h;
                ArrayList<Fragment> arrayList2 = dVar2.f10895i;
                if (arrayList2 != null) {
                    int size = arrayList2.size();
                    int i12 = i11 + 1;
                    this.mOps[i11] = size;
                    int i13 = 0;
                    while (i13 < size) {
                        this.mOps[i12] = dVar2.f10895i.get(i13).f40710j;
                        i13++;
                        i12++;
                    }
                    i5 = i12;
                } else {
                    iArr2[i11] = 0;
                    i5 = i11 + 1;
                }
            }
            this.mTransition = fVar.m;
            this.mTransitionStyle = fVar.n;
            this.mName = fVar.q;
            this.mIndex = fVar.s;
            this.mBreadCrumbTitleRes = fVar.t;
            this.mBreadCrumbTitleText = fVar.u;
            this.mBreadCrumbShortTitleRes = fVar.v;
            this.mBreadCrumbShortTitleText = fVar.w;
            this.mSharedElementSourceNames = fVar.x;
            this.mSharedElementTargetNames = fVar.y;
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

    public f instantiate(n nVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nVar)) == null) {
            f fVar = new f(nVar);
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.mOps.length) {
                f.d dVar = new f.d();
                int i4 = i2 + 1;
                dVar.f10889c = this.mOps[i2];
                if (n.x) {
                    String str = "Instantiate " + fVar + " op #" + i3 + " base fragment #" + this.mOps[i4];
                }
                int i5 = i4 + 1;
                int i6 = this.mOps[i4];
                if (i6 >= 0) {
                    dVar.f10890d = nVar.f10909d.get(i6);
                } else {
                    dVar.f10890d = null;
                }
                int[] iArr = this.mOps;
                int i7 = i5 + 1;
                dVar.f10891e = iArr[i5];
                int i8 = i7 + 1;
                dVar.f10892f = iArr[i7];
                int i9 = i8 + 1;
                dVar.f10893g = iArr[i8];
                int i10 = i9 + 1;
                dVar.f10894h = iArr[i9];
                int i11 = i10 + 1;
                int i12 = iArr[i10];
                if (i12 > 0) {
                    dVar.f10895i = new ArrayList<>(i12);
                    int i13 = 0;
                    while (i13 < i12) {
                        if (n.x) {
                            String str2 = "Instantiate " + fVar + " set remove fragment #" + this.mOps[i11];
                        }
                        dVar.f10895i.add(nVar.f10909d.get(this.mOps[i11]));
                        i13++;
                        i11++;
                    }
                }
                i2 = i11;
                fVar.o(dVar);
                i3++;
            }
            fVar.m = this.mTransition;
            fVar.n = this.mTransitionStyle;
            fVar.q = this.mName;
            fVar.s = this.mIndex;
            fVar.o = true;
            fVar.t = this.mBreadCrumbTitleRes;
            fVar.u = this.mBreadCrumbTitleText;
            fVar.v = this.mBreadCrumbShortTitleRes;
            fVar.w = this.mBreadCrumbShortTitleText;
            fVar.x = this.mSharedElementSourceNames;
            fVar.y = this.mSharedElementTargetNames;
            fVar.q(1);
            return fVar;
        }
        return (f) invokeL.objValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, parcel, i2) == null) {
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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

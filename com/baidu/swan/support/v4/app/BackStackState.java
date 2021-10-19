package com.baidu.swan.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import c.a.p0.o.a.a.e;
import c.a.p0.o.a.a.m;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
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

    public BackStackState(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
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
        for (e.d dVar = eVar.f12078f; dVar != null; dVar = dVar.f12095a) {
            ArrayList<Fragment> arrayList = dVar.f12103i;
            if (arrayList != null) {
                i4 += arrayList.size();
            }
        }
        this.mOps = new int[(eVar.f12080h * 7) + i4];
        if (eVar.o) {
            int i5 = 0;
            for (e.d dVar2 = eVar.f12078f; dVar2 != null; dVar2 = dVar2.f12095a) {
                int[] iArr = this.mOps;
                int i6 = i5 + 1;
                iArr[i5] = dVar2.f12097c;
                int i7 = i6 + 1;
                Fragment fragment = dVar2.f12098d;
                iArr[i6] = fragment != null ? fragment.f47247j : -1;
                int[] iArr2 = this.mOps;
                int i8 = i7 + 1;
                iArr2[i7] = dVar2.f12099e;
                int i9 = i8 + 1;
                iArr2[i8] = dVar2.f12100f;
                int i10 = i9 + 1;
                iArr2[i9] = dVar2.f12101g;
                int i11 = i10 + 1;
                iArr2[i10] = dVar2.f12102h;
                ArrayList<Fragment> arrayList2 = dVar2.f12103i;
                if (arrayList2 != null) {
                    int size = arrayList2.size();
                    int i12 = i11 + 1;
                    this.mOps[i11] = size;
                    int i13 = 0;
                    while (i13 < size) {
                        this.mOps[i12] = dVar2.f12103i.get(i13).f47247j;
                        i13++;
                        i12++;
                    }
                    i5 = i12;
                } else {
                    iArr2[i11] = 0;
                    i5 = i11 + 1;
                }
            }
            this.mTransition = eVar.m;
            this.mTransitionStyle = eVar.n;
            this.mName = eVar.p;
            this.mIndex = eVar.r;
            this.mBreadCrumbTitleRes = eVar.s;
            this.mBreadCrumbTitleText = eVar.t;
            this.mBreadCrumbShortTitleRes = eVar.u;
            this.mBreadCrumbShortTitleText = eVar.v;
            this.mSharedElementSourceNames = eVar.w;
            this.mSharedElementTargetNames = eVar.x;
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

    public e instantiate(m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mVar)) == null) {
            e eVar = new e(mVar);
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.mOps.length) {
                e.d dVar = new e.d();
                int i4 = i2 + 1;
                dVar.f12097c = this.mOps[i2];
                if (m.x) {
                    String str = "Instantiate " + eVar + " op #" + i3 + " base fragment #" + this.mOps[i4];
                }
                int i5 = i4 + 1;
                int i6 = this.mOps[i4];
                if (i6 >= 0) {
                    dVar.f12098d = mVar.f12120d.get(i6);
                } else {
                    dVar.f12098d = null;
                }
                int[] iArr = this.mOps;
                int i7 = i5 + 1;
                dVar.f12099e = iArr[i5];
                int i8 = i7 + 1;
                dVar.f12100f = iArr[i7];
                int i9 = i8 + 1;
                dVar.f12101g = iArr[i8];
                int i10 = i9 + 1;
                dVar.f12102h = iArr[i9];
                int i11 = i10 + 1;
                int i12 = iArr[i10];
                if (i12 > 0) {
                    dVar.f12103i = new ArrayList<>(i12);
                    int i13 = 0;
                    while (i13 < i12) {
                        if (m.x) {
                            String str2 = "Instantiate " + eVar + " set remove fragment #" + this.mOps[i11];
                        }
                        dVar.f12103i.add(mVar.f12120d.get(this.mOps[i11]));
                        i13++;
                        i11++;
                    }
                }
                i2 = i11;
                eVar.n(dVar);
                i3++;
            }
            eVar.m = this.mTransition;
            eVar.n = this.mTransitionStyle;
            eVar.p = this.mName;
            eVar.r = this.mIndex;
            eVar.o = true;
            eVar.s = this.mBreadCrumbTitleRes;
            eVar.t = this.mBreadCrumbTitleText;
            eVar.u = this.mBreadCrumbShortTitleRes;
            eVar.v = this.mBreadCrumbShortTitleText;
            eVar.w = this.mSharedElementSourceNames;
            eVar.x = this.mSharedElementTargetNames;
            eVar.p(1);
            return eVar;
        }
        return (e) invokeL.objValue;
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

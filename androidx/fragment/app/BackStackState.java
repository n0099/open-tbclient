package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class BackStackState implements Parcelable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Parcelable.Creator<BackStackState> CREATOR;
    public static final String TAG = "FragmentManager";
    public transient /* synthetic */ FieldHolder $fh;
    public final int mBreadCrumbShortTitleRes;
    public final CharSequence mBreadCrumbShortTitleText;
    public final int mBreadCrumbTitleRes;
    public final CharSequence mBreadCrumbTitleText;
    public final int[] mCurrentMaxLifecycleStates;
    public final ArrayList<String> mFragmentWhos;
    public final int mIndex;
    public final String mName;
    public final int[] mOldMaxLifecycleStates;
    public final int[] mOps;
    public final boolean mReorderingAllowed;
    public final ArrayList<String> mSharedElementSourceNames;
    public final ArrayList<String> mSharedElementTargetNames;
    public final int mTransition;

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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-71973800, "Landroidx/fragment/app/BackStackState;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-71973800, "Landroidx/fragment/app/BackStackState;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<BackStackState>() { // from class: androidx.fragment.app.BackStackState.1
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
            public BackStackState createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                    return new BackStackState(parcel);
                }
                return (BackStackState) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public BackStackState[] newArray(int i) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                    return new BackStackState[i];
                }
                return (BackStackState[]) invokeI.objValue;
            }
        };
    }

    public BackStackState(Parcel parcel) {
        boolean z;
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
        this.mFragmentWhos = parcel.createStringArrayList();
        this.mOldMaxLifecycleStates = parcel.createIntArray();
        this.mCurrentMaxLifecycleStates = parcel.createIntArray();
        this.mTransition = parcel.readInt();
        this.mName = parcel.readString();
        this.mIndex = parcel.readInt();
        this.mBreadCrumbTitleRes = parcel.readInt();
        this.mBreadCrumbTitleText = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mBreadCrumbShortTitleRes = parcel.readInt();
        this.mBreadCrumbShortTitleText = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mSharedElementSourceNames = parcel.createStringArrayList();
        this.mSharedElementTargetNames = parcel.createStringArrayList();
        if (parcel.readInt() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.mReorderingAllowed = z;
    }

    public BackStackState(BackStackRecord backStackRecord) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {backStackRecord};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        int size = backStackRecord.mOps.size();
        this.mOps = new int[size * 5];
        if (backStackRecord.mAddToBackStack) {
            this.mFragmentWhos = new ArrayList<>(size);
            this.mOldMaxLifecycleStates = new int[size];
            this.mCurrentMaxLifecycleStates = new int[size];
            int i3 = 0;
            int i4 = 0;
            while (i3 < size) {
                FragmentTransaction.Op op = backStackRecord.mOps.get(i3);
                int i5 = i4 + 1;
                this.mOps[i4] = op.mCmd;
                ArrayList<String> arrayList = this.mFragmentWhos;
                Fragment fragment = op.mFragment;
                if (fragment != null) {
                    str = fragment.mWho;
                } else {
                    str = null;
                }
                arrayList.add(str);
                int[] iArr = this.mOps;
                int i6 = i5 + 1;
                iArr[i5] = op.mEnterAnim;
                int i7 = i6 + 1;
                iArr[i6] = op.mExitAnim;
                int i8 = i7 + 1;
                iArr[i7] = op.mPopEnterAnim;
                iArr[i8] = op.mPopExitAnim;
                this.mOldMaxLifecycleStates[i3] = op.mOldMaxState.ordinal();
                this.mCurrentMaxLifecycleStates[i3] = op.mCurrentMaxState.ordinal();
                i3++;
                i4 = i8 + 1;
            }
            this.mTransition = backStackRecord.mTransition;
            this.mName = backStackRecord.mName;
            this.mIndex = backStackRecord.mIndex;
            this.mBreadCrumbTitleRes = backStackRecord.mBreadCrumbTitleRes;
            this.mBreadCrumbTitleText = backStackRecord.mBreadCrumbTitleText;
            this.mBreadCrumbShortTitleRes = backStackRecord.mBreadCrumbShortTitleRes;
            this.mBreadCrumbShortTitleText = backStackRecord.mBreadCrumbShortTitleText;
            this.mSharedElementSourceNames = backStackRecord.mSharedElementSourceNames;
            this.mSharedElementTargetNames = backStackRecord.mSharedElementTargetNames;
            this.mReorderingAllowed = backStackRecord.mReorderingAllowed;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    public BackStackRecord instantiate(FragmentManager fragmentManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fragmentManager)) == null) {
            BackStackRecord backStackRecord = new BackStackRecord(fragmentManager);
            int i = 0;
            int i2 = 0;
            while (i < this.mOps.length) {
                FragmentTransaction.Op op = new FragmentTransaction.Op();
                int i3 = i + 1;
                op.mCmd = this.mOps[i];
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v("FragmentManager", "Instantiate " + backStackRecord + " op #" + i2 + " base fragment #" + this.mOps[i3]);
                }
                String str = this.mFragmentWhos.get(i2);
                if (str != null) {
                    op.mFragment = fragmentManager.findActiveFragment(str);
                } else {
                    op.mFragment = null;
                }
                op.mOldMaxState = Lifecycle.State.values()[this.mOldMaxLifecycleStates[i2]];
                op.mCurrentMaxState = Lifecycle.State.values()[this.mCurrentMaxLifecycleStates[i2]];
                int[] iArr = this.mOps;
                int i4 = i3 + 1;
                int i5 = iArr[i3];
                op.mEnterAnim = i5;
                int i6 = i4 + 1;
                int i7 = iArr[i4];
                op.mExitAnim = i7;
                int i8 = i6 + 1;
                int i9 = iArr[i6];
                op.mPopEnterAnim = i9;
                int i10 = iArr[i8];
                op.mPopExitAnim = i10;
                backStackRecord.mEnterAnim = i5;
                backStackRecord.mExitAnim = i7;
                backStackRecord.mPopEnterAnim = i9;
                backStackRecord.mPopExitAnim = i10;
                backStackRecord.addOp(op);
                i2++;
                i = i8 + 1;
            }
            backStackRecord.mTransition = this.mTransition;
            backStackRecord.mName = this.mName;
            backStackRecord.mIndex = this.mIndex;
            backStackRecord.mAddToBackStack = true;
            backStackRecord.mBreadCrumbTitleRes = this.mBreadCrumbTitleRes;
            backStackRecord.mBreadCrumbTitleText = this.mBreadCrumbTitleText;
            backStackRecord.mBreadCrumbShortTitleRes = this.mBreadCrumbShortTitleRes;
            backStackRecord.mBreadCrumbShortTitleText = this.mBreadCrumbShortTitleText;
            backStackRecord.mSharedElementSourceNames = this.mSharedElementSourceNames;
            backStackRecord.mSharedElementTargetNames = this.mSharedElementTargetNames;
            backStackRecord.mReorderingAllowed = this.mReorderingAllowed;
            backStackRecord.bumpBackStackNesting(1);
            return backStackRecord;
        }
        return (BackStackRecord) invokeL.objValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, parcel, i) == null) {
            parcel.writeIntArray(this.mOps);
            parcel.writeStringList(this.mFragmentWhos);
            parcel.writeIntArray(this.mOldMaxLifecycleStates);
            parcel.writeIntArray(this.mCurrentMaxLifecycleStates);
            parcel.writeInt(this.mTransition);
            parcel.writeString(this.mName);
            parcel.writeInt(this.mIndex);
            parcel.writeInt(this.mBreadCrumbTitleRes);
            TextUtils.writeToParcel(this.mBreadCrumbTitleText, parcel, 0);
            parcel.writeInt(this.mBreadCrumbShortTitleRes);
            TextUtils.writeToParcel(this.mBreadCrumbShortTitleText, parcel, 0);
            parcel.writeStringList(this.mSharedElementSourceNames);
            parcel.writeStringList(this.mSharedElementTargetNames);
            parcel.writeInt(this.mReorderingAllowed ? 1 : 0);
        }
    }
}

package androidx.recyclerview.widget;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public class ViewBoundsCheck {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CVE_PVE_POS = 12;
    public static final int CVE_PVS_POS = 8;
    public static final int CVS_PVE_POS = 4;
    public static final int CVS_PVS_POS = 0;
    public static final int EQ = 2;
    public static final int FLAG_CVE_EQ_PVE = 8192;
    public static final int FLAG_CVE_EQ_PVS = 512;
    public static final int FLAG_CVE_GT_PVE = 4096;
    public static final int FLAG_CVE_GT_PVS = 256;
    public static final int FLAG_CVE_LT_PVE = 16384;
    public static final int FLAG_CVE_LT_PVS = 1024;
    public static final int FLAG_CVS_EQ_PVE = 32;
    public static final int FLAG_CVS_EQ_PVS = 2;
    public static final int FLAG_CVS_GT_PVE = 16;
    public static final int FLAG_CVS_GT_PVS = 1;
    public static final int FLAG_CVS_LT_PVE = 64;
    public static final int FLAG_CVS_LT_PVS = 4;
    public static final int GT = 1;
    public static final int LT = 4;
    public static final int MASK = 7;
    public transient /* synthetic */ FieldHolder $fh;
    public BoundFlags mBoundFlags;
    public final Callback mCallback;

    /* loaded from: classes.dex */
    public static class BoundFlags {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int mBoundFlags;
        public int mChildEnd;
        public int mChildStart;
        public int mRvEnd;
        public int mRvStart;

        public BoundFlags() {
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
            this.mBoundFlags = 0;
        }

        public void addFlags(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.mBoundFlags = i | this.mBoundFlags;
            }
        }

        public boolean boundsMatch() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                int i = this.mBoundFlags;
                if ((i & 7) == 0 || (i & (compare(this.mChildStart, this.mRvStart) << 0)) != 0) {
                    int i2 = this.mBoundFlags;
                    if ((i2 & 112) == 0 || (i2 & (compare(this.mChildStart, this.mRvEnd) << 4)) != 0) {
                        int i3 = this.mBoundFlags;
                        if ((i3 & 1792) == 0 || (i3 & (compare(this.mChildEnd, this.mRvStart) << 8)) != 0) {
                            int i4 = this.mBoundFlags;
                            return (i4 & 28672) == 0 || (i4 & (compare(this.mChildEnd, this.mRvEnd) << 12)) != 0;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public int compare(int i, int i2) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2)) == null) {
                if (i > i2) {
                    return 1;
                }
                return i == i2 ? 2 : 4;
            }
            return invokeII.intValue;
        }

        public void resetFlags() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.mBoundFlags = 0;
            }
        }

        public void setBounds(int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(1048580, this, i, i2, i3, i4) == null) {
                this.mRvStart = i;
                this.mRvEnd = i2;
                this.mChildStart = i3;
                this.mChildEnd = i4;
            }
        }
    }

    /* loaded from: classes.dex */
    public interface Callback {
        View getChildAt(int i);

        int getChildEnd(View view2);

        int getChildStart(View view2);

        int getParentEnd();

        int getParentStart();
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface ViewBounds {
    }

    public ViewBoundsCheck(Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {callback};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mCallback = callback;
        this.mBoundFlags = new BoundFlags();
    }

    public View findOneViewWithinBoundFlags(int i, int i2, int i3, int i4) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048576, this, i, i2, i3, i4)) == null) {
            int parentStart = this.mCallback.getParentStart();
            int parentEnd = this.mCallback.getParentEnd();
            int i5 = i2 > i ? 1 : -1;
            View view2 = null;
            while (i != i2) {
                View childAt = this.mCallback.getChildAt(i);
                this.mBoundFlags.setBounds(parentStart, parentEnd, this.mCallback.getChildStart(childAt), this.mCallback.getChildEnd(childAt));
                if (i3 != 0) {
                    this.mBoundFlags.resetFlags();
                    this.mBoundFlags.addFlags(i3);
                    if (this.mBoundFlags.boundsMatch()) {
                        return childAt;
                    }
                }
                if (i4 != 0) {
                    this.mBoundFlags.resetFlags();
                    this.mBoundFlags.addFlags(i4);
                    if (this.mBoundFlags.boundsMatch()) {
                        view2 = childAt;
                    }
                }
                i += i5;
            }
            return view2;
        }
        return (View) invokeIIII.objValue;
    }

    public boolean isViewWithinBoundFlags(View view2, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, i)) == null) {
            this.mBoundFlags.setBounds(this.mCallback.getParentStart(), this.mCallback.getParentEnd(), this.mCallback.getChildStart(view2), this.mCallback.getChildEnd(view2));
            if (i != 0) {
                this.mBoundFlags.resetFlags();
                this.mBoundFlags.addFlags(i);
                return this.mBoundFlags.boundsMatch();
            }
            return false;
        }
        return invokeLI.booleanValue;
    }
}

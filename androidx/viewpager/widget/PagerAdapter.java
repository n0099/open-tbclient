package androidx.viewpager.widget;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public abstract class PagerAdapter {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int POSITION_NONE = -2;
    public static final int POSITION_UNCHANGED = -1;
    public transient /* synthetic */ FieldHolder $fh;
    public final DataSetObservable mObservable;
    public DataSetObserver mViewPagerObserver;

    @Deprecated
    public void finishUpdate(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
        }
    }

    public abstract int getCount();

    public int getItemPosition(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            return -1;
        }
        return invokeL.intValue;
    }

    public CharSequence getPageTitle(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            return null;
        }
        return (CharSequence) invokeI.objValue;
    }

    public float getPageWidth(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            return 1.0f;
        }
        return invokeI.floatValue;
    }

    public abstract boolean isViewFromObject(View view2, Object obj);

    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, parcelable, classLoader) == null) {
        }
    }

    public Parcelable saveState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return null;
        }
        return (Parcelable) invokeV.objValue;
    }

    @Deprecated
    public void setPrimaryItem(View view2, int i, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048591, this, view2, i, obj) == null) {
        }
    }

    @Deprecated
    public void startUpdate(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, view2) == null) {
        }
    }

    public PagerAdapter() {
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
        this.mObservable = new DataSetObservable();
    }

    public void notifyDataSetChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            synchronized (this) {
                if (this.mViewPagerObserver != null) {
                    this.mViewPagerObserver.onChanged();
                }
            }
            this.mObservable.notifyChanged();
        }
    }

    @Deprecated
    public void destroyItem(View view2, int i, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, view2, i, obj) == null) {
            throw new UnsupportedOperationException("Required method destroyItem was not overridden");
        }
    }

    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048592, this, viewGroup, i, obj) == null) {
            setPrimaryItem((View) viewGroup, i, obj);
        }
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i, obj) == null) {
            destroyItem((View) viewGroup, i, obj);
        }
    }

    public void finishUpdate(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, viewGroup) == null) {
            finishUpdate((View) viewGroup);
        }
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, dataSetObserver) == null) {
            this.mObservable.registerObserver(dataSetObserver);
        }
    }

    public void setViewPagerObserver(DataSetObserver dataSetObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, dataSetObserver) == null) {
            synchronized (this) {
                this.mViewPagerObserver = dataSetObserver;
            }
        }
    }

    public void startUpdate(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, viewGroup) == null) {
            startUpdate((View) viewGroup);
        }
    }

    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, dataSetObserver) == null) {
            this.mObservable.unregisterObserver(dataSetObserver);
        }
    }

    @Deprecated
    public Object instantiateItem(View view2, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2, i)) == null) {
            throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
        }
        return invokeLI.objValue;
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048585, this, viewGroup, i)) == null) {
            return instantiateItem((View) viewGroup, i);
        }
        return invokeLI.objValue;
    }
}

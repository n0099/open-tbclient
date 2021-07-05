package androidx.viewpager.widget;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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

    public PagerAdapter() {
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
        this.mObservable = new DataSetObservable();
    }

    public void destroyItem(@NonNull ViewGroup viewGroup, int i2, @NonNull Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i2, obj) == null) {
            destroyItem((View) viewGroup, i2, obj);
        }
    }

    @Deprecated
    public void finishUpdate(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
        }
    }

    public void finishUpdate(@NonNull ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, viewGroup) == null) {
            finishUpdate((View) viewGroup);
        }
    }

    public abstract int getCount();

    public int getItemPosition(@NonNull Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            return -1;
        }
        return invokeL.intValue;
    }

    @Nullable
    public CharSequence getPageTitle(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            return null;
        }
        return (CharSequence) invokeI.objValue;
    }

    public float getPageWidth(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            return 1.0f;
        }
        return invokeI.floatValue;
    }

    @NonNull
    public Object instantiateItem(@NonNull ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048585, this, viewGroup, i2)) == null) ? instantiateItem((View) viewGroup, i2) : invokeLI.objValue;
    }

    public abstract boolean isViewFromObject(@NonNull View view, @NonNull Object obj);

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

    public void registerDataSetObserver(@NonNull DataSetObserver dataSetObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, dataSetObserver) == null) {
            this.mObservable.registerObserver(dataSetObserver);
        }
    }

    public void restoreState(@Nullable Parcelable parcelable, @Nullable ClassLoader classLoader) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, parcelable, classLoader) == null) {
        }
    }

    @Nullable
    public Parcelable saveState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return null;
        }
        return (Parcelable) invokeV.objValue;
    }

    @Deprecated
    public void setPrimaryItem(@NonNull View view, int i2, @NonNull Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048591, this, view, i2, obj) == null) {
        }
    }

    public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i2, @NonNull Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048592, this, viewGroup, i2, obj) == null) {
            setPrimaryItem((View) viewGroup, i2, obj);
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

    @Deprecated
    public void startUpdate(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, view) == null) {
        }
    }

    public void startUpdate(@NonNull ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, viewGroup) == null) {
            startUpdate((View) viewGroup);
        }
    }

    public void unregisterDataSetObserver(@NonNull DataSetObserver dataSetObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, dataSetObserver) == null) {
            this.mObservable.unregisterObserver(dataSetObserver);
        }
    }

    @Deprecated
    public void destroyItem(@NonNull View view, int i2, @NonNull Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, view, i2, obj) == null) {
            throw new UnsupportedOperationException("Required method destroyItem was not overridden");
        }
    }

    @NonNull
    @Deprecated
    public Object instantiateItem(@NonNull View view, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, view, i2)) == null) {
            throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
        }
        return invokeLI.objValue;
    }
}

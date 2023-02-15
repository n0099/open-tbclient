package androidx.transition;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
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
public class Scene {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public Runnable mEnterAction;
    public Runnable mExitAction;
    public View mLayout;
    public int mLayoutId;
    public ViewGroup mSceneRoot;

    public Scene(@NonNull ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mLayoutId = -1;
        this.mSceneRoot = viewGroup;
    }

    @Nullable
    public static Scene getCurrentScene(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, viewGroup)) == null) {
            return (Scene) viewGroup.getTag(com.baidu.tieba.R.id.obfuscated_res_0x7f092470);
        }
        return (Scene) invokeL.objValue;
    }

    public void setEnterAction(@Nullable Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, runnable) == null) {
            this.mEnterAction = runnable;
        }
    }

    public void setExitAction(@Nullable Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, runnable) == null) {
            this.mExitAction = runnable;
        }
    }

    public Scene(ViewGroup viewGroup, int i, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {viewGroup, Integer.valueOf(i), context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mLayoutId = -1;
        this.mContext = context;
        this.mSceneRoot = viewGroup;
        this.mLayoutId = i;
    }

    @NonNull
    public static Scene getSceneForLayout(@NonNull ViewGroup viewGroup, @LayoutRes int i, @NonNull Context context) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(InputDeviceCompat.SOURCE_TRACKBALL, null, viewGroup, i, context)) == null) {
            SparseArray sparseArray = (SparseArray) viewGroup.getTag(com.baidu.tieba.R.id.obfuscated_res_0x7f092473);
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                viewGroup.setTag(com.baidu.tieba.R.id.obfuscated_res_0x7f092473, sparseArray);
            }
            Scene scene = (Scene) sparseArray.get(i);
            if (scene != null) {
                return scene;
            }
            Scene scene2 = new Scene(viewGroup, i, context);
            sparseArray.put(i, scene2);
            return scene2;
        }
        return (Scene) invokeLIL.objValue;
    }

    public Scene(@NonNull ViewGroup viewGroup, @NonNull View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {viewGroup, view2};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mLayoutId = -1;
        this.mSceneRoot = viewGroup;
        this.mLayout = view2;
    }

    public static void setCurrentScene(@NonNull ViewGroup viewGroup, @Nullable Scene scene) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, viewGroup, scene) == null) {
            viewGroup.setTag(com.baidu.tieba.R.id.obfuscated_res_0x7f092470, scene);
        }
    }

    public void enter() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.mLayoutId > 0 || this.mLayout != null) {
                getSceneRoot().removeAllViews();
                if (this.mLayoutId > 0) {
                    LayoutInflater.from(this.mContext).inflate(this.mLayoutId, this.mSceneRoot);
                } else {
                    this.mSceneRoot.addView(this.mLayout);
                }
            }
            Runnable runnable = this.mEnterAction;
            if (runnable != null) {
                runnable.run();
            }
            setCurrentScene(this.mSceneRoot, this);
        }
    }

    public void exit() {
        Runnable runnable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && getCurrentScene(this.mSceneRoot) == this && (runnable = this.mExitAction) != null) {
            runnable.run();
        }
    }

    @NonNull
    public ViewGroup getSceneRoot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mSceneRoot;
        }
        return (ViewGroup) invokeV.objValue;
    }

    public boolean isCreatedFromLayoutResource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.mLayoutId > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}

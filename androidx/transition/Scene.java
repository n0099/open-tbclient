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
import com.baidu.mobads.container.util.AdIconUtil;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, viewGroup)) == null) ? (Scene) viewGroup.getTag(R.id.transition_current_scene) : (Scene) invokeL.objValue;
    }

    @NonNull
    public static Scene getSceneForLayout(@NonNull ViewGroup viewGroup, @LayoutRes int i2, @NonNull Context context) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(InputDeviceCompat.SOURCE_TRACKBALL, null, viewGroup, i2, context)) == null) {
            SparseArray sparseArray = (SparseArray) viewGroup.getTag(R.id.transition_scene_layoutid_cache);
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                viewGroup.setTag(R.id.transition_scene_layoutid_cache, sparseArray);
            }
            Scene scene = (Scene) sparseArray.get(i2);
            if (scene != null) {
                return scene;
            }
            Scene scene2 = new Scene(viewGroup, i2, context);
            sparseArray.put(i2, scene2);
            return scene2;
        }
        return (Scene) invokeLIL.objValue;
    }

    public static void setCurrentScene(@NonNull ViewGroup viewGroup, @Nullable Scene scene) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, viewGroup, scene) == null) {
            viewGroup.setTag(R.id.transition_current_scene, scene);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mSceneRoot : (ViewGroup) invokeV.objValue;
    }

    public boolean isCreatedFromLayoutResource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mLayoutId > 0 : invokeV.booleanValue;
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

    public Scene(ViewGroup viewGroup, int i2, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {viewGroup, Integer.valueOf(i2), context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mLayoutId = -1;
        this.mContext = context;
        this.mSceneRoot = viewGroup;
        this.mLayoutId = i2;
    }

    public Scene(@NonNull ViewGroup viewGroup, @NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {viewGroup, view};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mLayoutId = -1;
        this.mSceneRoot = viewGroup;
        this.mLayout = view;
    }
}

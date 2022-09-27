package androidx.transition;

import android.animation.LayoutTransition;
import android.util.Log;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class ViewGroupUtilsApi14 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int LAYOUT_TRANSITION_CHANGING = 4;
    public static final String TAG = "ViewGroupUtilsApi14";
    public static Method sCancelMethod;
    public static boolean sCancelMethodFetched;
    public static LayoutTransition sEmptyLayoutTransition;
    public static Field sLayoutSuppressedField;
    public static boolean sLayoutSuppressedFieldFetched;
    public transient /* synthetic */ FieldHolder $fh;

    public ViewGroupUtilsApi14() {
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

    public static void cancelLayoutTransition(LayoutTransition layoutTransition) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, layoutTransition) == null) {
            if (!sCancelMethodFetched) {
                try {
                    Method declaredMethod = LayoutTransition.class.getDeclaredMethod("cancel", new Class[0]);
                    sCancelMethod = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (NoSuchMethodException unused) {
                    Log.i(TAG, "Failed to access cancel method by reflection");
                }
                sCancelMethodFetched = true;
            }
            Method method = sCancelMethod;
            if (method != null) {
                try {
                    method.invoke(layoutTransition, new Object[0]);
                } catch (IllegalAccessException unused2) {
                    Log.i(TAG, "Failed to access cancel method by reflection");
                } catch (InvocationTargetException unused3) {
                    Log.i(TAG, "Failed to invoke cancel method by reflection");
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void suppressLayout(@NonNull ViewGroup viewGroup, boolean z) {
        LayoutTransition layoutTransition;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65538, null, viewGroup, z) == null) {
            boolean z2 = false;
            if (sEmptyLayoutTransition == null) {
                LayoutTransition layoutTransition2 = new LayoutTransition() { // from class: androidx.transition.ViewGroupUtilsApi14.1
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

                    @Override // android.animation.LayoutTransition
                    public boolean isChangingLayout() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                            return true;
                        }
                        return invokeV.booleanValue;
                    }
                };
                sEmptyLayoutTransition = layoutTransition2;
                layoutTransition2.setAnimator(2, null);
                sEmptyLayoutTransition.setAnimator(0, null);
                sEmptyLayoutTransition.setAnimator(1, null);
                sEmptyLayoutTransition.setAnimator(3, null);
                sEmptyLayoutTransition.setAnimator(4, null);
            }
            if (z) {
                LayoutTransition layoutTransition3 = viewGroup.getLayoutTransition();
                if (layoutTransition3 != null) {
                    if (layoutTransition3.isRunning()) {
                        cancelLayoutTransition(layoutTransition3);
                    }
                    if (layoutTransition3 != sEmptyLayoutTransition) {
                        viewGroup.setTag(com.baidu.tieba.R.id.obfuscated_res_0x7f09232a, layoutTransition3);
                    }
                }
                viewGroup.setLayoutTransition(sEmptyLayoutTransition);
                return;
            }
            viewGroup.setLayoutTransition(null);
            if (!sLayoutSuppressedFieldFetched) {
                try {
                    Field declaredField = ViewGroup.class.getDeclaredField("mLayoutSuppressed");
                    sLayoutSuppressedField = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException unused) {
                    Log.i(TAG, "Failed to access mLayoutSuppressed field by reflection");
                }
                sLayoutSuppressedFieldFetched = true;
            }
            Field field = sLayoutSuppressedField;
            if (field != null) {
                try {
                    boolean z3 = field.getBoolean(viewGroup);
                    if (z3) {
                        try {
                            sLayoutSuppressedField.setBoolean(viewGroup, false);
                        } catch (IllegalAccessException unused2) {
                            z2 = z3;
                            Log.i(TAG, "Failed to get mLayoutSuppressed field by reflection");
                            if (z2) {
                            }
                            layoutTransition = (LayoutTransition) viewGroup.getTag(com.baidu.tieba.R.id.obfuscated_res_0x7f09232a);
                            if (layoutTransition == null) {
                            }
                        }
                    }
                    z2 = z3;
                } catch (IllegalAccessException unused3) {
                }
            }
            if (z2) {
                viewGroup.requestLayout();
            }
            layoutTransition = (LayoutTransition) viewGroup.getTag(com.baidu.tieba.R.id.obfuscated_res_0x7f09232a);
            if (layoutTransition == null) {
                viewGroup.setTag(com.baidu.tieba.R.id.obfuscated_res_0x7f09232a, null);
                viewGroup.setLayoutTransition(layoutTransition);
            }
        }
    }
}

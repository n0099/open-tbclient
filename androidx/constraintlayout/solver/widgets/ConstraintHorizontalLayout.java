package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class ConstraintHorizontalLayout extends ConstraintWidgetContainer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ContentAlignment mAlignment;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class ContentAlignment {
        public static final /* synthetic */ ContentAlignment[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ContentAlignment BEGIN;
        public static final ContentAlignment BOTTOM;
        public static final ContentAlignment END;
        public static final ContentAlignment LEFT;
        public static final ContentAlignment MIDDLE;
        public static final ContentAlignment RIGHT;
        public static final ContentAlignment TOP;
        public static final ContentAlignment VERTICAL_MIDDLE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1664318266, "Landroidx/constraintlayout/solver/widgets/ConstraintHorizontalLayout$ContentAlignment;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1664318266, "Landroidx/constraintlayout/solver/widgets/ConstraintHorizontalLayout$ContentAlignment;");
                    return;
                }
            }
            BEGIN = new ContentAlignment("BEGIN", 0);
            MIDDLE = new ContentAlignment("MIDDLE", 1);
            END = new ContentAlignment("END", 2);
            TOP = new ContentAlignment("TOP", 3);
            VERTICAL_MIDDLE = new ContentAlignment("VERTICAL_MIDDLE", 4);
            BOTTOM = new ContentAlignment("BOTTOM", 5);
            LEFT = new ContentAlignment("LEFT", 6);
            ContentAlignment contentAlignment = new ContentAlignment("RIGHT", 7);
            RIGHT = contentAlignment;
            $VALUES = new ContentAlignment[]{BEGIN, MIDDLE, END, TOP, VERTICAL_MIDDLE, BOTTOM, LEFT, contentAlignment};
        }

        public ContentAlignment(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static ContentAlignment valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ContentAlignment) Enum.valueOf(ContentAlignment.class, str) : (ContentAlignment) invokeL.objValue;
        }

        public static ContentAlignment[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ContentAlignment[]) $VALUES.clone() : (ContentAlignment[]) invokeV.objValue;
        }
    }

    public ConstraintHorizontalLayout() {
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
        this.mAlignment = ContentAlignment.MIDDLE;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void addToSolver(LinearSystem linearSystem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, linearSystem) == null) {
            if (this.mChildren.size() != 0) {
                int i2 = 0;
                int size = this.mChildren.size();
                ConstraintWidget constraintWidget = this;
                while (i2 < size) {
                    ConstraintWidget constraintWidget2 = this.mChildren.get(i2);
                    if (constraintWidget != this) {
                        constraintWidget2.connect(ConstraintAnchor.Type.LEFT, constraintWidget, ConstraintAnchor.Type.RIGHT);
                        constraintWidget.connect(ConstraintAnchor.Type.RIGHT, constraintWidget2, ConstraintAnchor.Type.LEFT);
                    } else {
                        ConstraintAnchor.Strength strength = ConstraintAnchor.Strength.STRONG;
                        if (this.mAlignment == ContentAlignment.END) {
                            strength = ConstraintAnchor.Strength.WEAK;
                        }
                        ConstraintAnchor.Type type = ConstraintAnchor.Type.LEFT;
                        constraintWidget2.connect(type, constraintWidget, type, 0, strength);
                    }
                    ConstraintAnchor.Type type2 = ConstraintAnchor.Type.TOP;
                    constraintWidget2.connect(type2, this, type2);
                    ConstraintAnchor.Type type3 = ConstraintAnchor.Type.BOTTOM;
                    constraintWidget2.connect(type3, this, type3);
                    i2++;
                    constraintWidget = constraintWidget2;
                }
                if (constraintWidget != this) {
                    ConstraintAnchor.Strength strength2 = ConstraintAnchor.Strength.STRONG;
                    if (this.mAlignment == ContentAlignment.BEGIN) {
                        strength2 = ConstraintAnchor.Strength.WEAK;
                    }
                    ConstraintAnchor.Type type4 = ConstraintAnchor.Type.RIGHT;
                    constraintWidget.connect(type4, this, type4, 0, strength2);
                }
            }
            super.addToSolver(linearSystem);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConstraintHorizontalLayout(int i2, int i3, int i4, int i5) {
        super(i2, i3, i4, i5);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i6 = newInitContext.flag;
            if ((i6 & 1) != 0) {
                int i7 = i6 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mAlignment = ContentAlignment.MIDDLE;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConstraintHorizontalLayout(int i2, int i3) {
        super(i2, i3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mAlignment = ContentAlignment.MIDDLE;
    }
}

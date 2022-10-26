package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;
import androidx.constraintlayout.widget.R;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.monitor.SessionMonitorEngine;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public class ConstraintSet {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ALPHA = 43;
    public static final int ANIMATE_RELATIVE_TO = 64;
    public static final int BARRIER_ALLOWS_GONE_WIDGETS = 75;
    public static final int BARRIER_DIRECTION = 72;
    public static final int BARRIER_MARGIN = 73;
    public static final int BARRIER_TYPE = 1;
    public static final int BASELINE = 5;
    public static final int BASELINE_TO_BASELINE = 1;
    public static final int BOTTOM = 4;
    public static final int BOTTOM_MARGIN = 2;
    public static final int BOTTOM_TO_BOTTOM = 3;
    public static final int BOTTOM_TO_TOP = 4;
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    public static final int CHAIN_USE_RTL = 71;
    public static final int CIRCLE = 61;
    public static final int CIRCLE_ANGLE = 63;
    public static final int CIRCLE_RADIUS = 62;
    public static final int CONSTRAINED_HEIGHT = 81;
    public static final int CONSTRAINED_WIDTH = 80;
    public static final int CONSTRAINT_REFERENCED_IDS = 74;
    public static final int CONSTRAINT_TAG = 77;
    public static final boolean DEBUG = false;
    public static final int DIMENSION_RATIO = 5;
    public static final int DRAW_PATH = 66;
    public static final int EDITOR_ABSOLUTE_X = 6;
    public static final int EDITOR_ABSOLUTE_Y = 7;
    public static final int ELEVATION = 44;
    public static final int END = 7;
    public static final int END_MARGIN = 8;
    public static final int END_TO_END = 9;
    public static final int END_TO_START = 10;
    public static final String ERROR_MESSAGE = "XML parser error must be within a Constraint ";
    public static final int GONE = 8;
    public static final int GONE_BOTTOM_MARGIN = 11;
    public static final int GONE_END_MARGIN = 12;
    public static final int GONE_LEFT_MARGIN = 13;
    public static final int GONE_RIGHT_MARGIN = 14;
    public static final int GONE_START_MARGIN = 15;
    public static final int GONE_TOP_MARGIN = 16;
    public static final int GUIDE_BEGIN = 17;
    public static final int GUIDE_END = 18;
    public static final int GUIDE_PERCENT = 19;
    public static final int HEIGHT_DEFAULT = 55;
    public static final int HEIGHT_MAX = 57;
    public static final int HEIGHT_MIN = 59;
    public static final int HEIGHT_PERCENT = 70;
    public static final int HORIZONTAL = 0;
    public static final int HORIZONTAL_BIAS = 20;
    public static final int HORIZONTAL_GUIDELINE = 0;
    public static final int HORIZONTAL_STYLE = 41;
    public static final int HORIZONTAL_WEIGHT = 39;
    public static final int INVISIBLE = 4;
    public static final int LAYOUT_HEIGHT = 21;
    public static final int LAYOUT_VISIBILITY = 22;
    public static final int LAYOUT_WIDTH = 23;
    public static final int LEFT = 1;
    public static final int LEFT_MARGIN = 24;
    public static final int LEFT_TO_LEFT = 25;
    public static final int LEFT_TO_RIGHT = 26;
    public static final int MATCH_CONSTRAINT = 0;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    public static final int MOTION_STAGGER = 79;
    public static final int ORIENTATION = 27;
    public static final int PARENT_ID = 0;
    public static final int PATH_MOTION_ARC = 76;
    public static final int PROGRESS = 68;
    public static final int RIGHT = 2;
    public static final int RIGHT_MARGIN = 28;
    public static final int RIGHT_TO_LEFT = 29;
    public static final int RIGHT_TO_RIGHT = 30;
    public static final int ROTATION = 60;
    public static final int ROTATION_X = 45;
    public static final int ROTATION_Y = 46;
    public static final int SCALE_X = 47;
    public static final int SCALE_Y = 48;
    public static final int START = 6;
    public static final int START_MARGIN = 31;
    public static final int START_TO_END = 32;
    public static final int START_TO_START = 33;
    public static final String TAG = "ConstraintSet";
    public static final int TOP = 3;
    public static final int TOP_MARGIN = 34;
    public static final int TOP_TO_BOTTOM = 35;
    public static final int TOP_TO_TOP = 36;
    public static final int TRANSFORM_PIVOT_X = 49;
    public static final int TRANSFORM_PIVOT_Y = 50;
    public static final int TRANSITION_EASING = 65;
    public static final int TRANSITION_PATH_ROTATE = 67;
    public static final int TRANSLATION_X = 51;
    public static final int TRANSLATION_Y = 52;
    public static final int TRANSLATION_Z = 53;
    public static final int UNSET = -1;
    public static final int UNUSED = 82;
    public static final int VERTICAL = 1;
    public static final int VERTICAL_BIAS = 37;
    public static final int VERTICAL_GUIDELINE = 1;
    public static final int VERTICAL_STYLE = 42;
    public static final int VERTICAL_WEIGHT = 40;
    public static final int VIEW_ID = 38;
    public static final int[] VISIBILITY_FLAGS;
    public static final int VISIBILITY_MODE = 78;
    public static final int VISIBILITY_MODE_IGNORE = 1;
    public static final int VISIBILITY_MODE_NORMAL = 0;
    public static final int VISIBLE = 0;
    public static final int WIDTH_DEFAULT = 54;
    public static final int WIDTH_MAX = 56;
    public static final int WIDTH_MIN = 58;
    public static final int WIDTH_PERCENT = 69;
    public static final int WRAP_CONTENT = -2;
    public static SparseIntArray mapToConstant;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<Integer, Constraint> mConstraints;
    public boolean mForceId;
    public HashMap<String, ConstraintAttribute> mSavedAttributes;
    public boolean mValidate;

    private String sideToString(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65547, this, i)) == null) {
            switch (i) {
                case 1:
                    return "left";
                case 2:
                    return "right";
                case 3:
                    return "top";
                case 4:
                    return "bottom";
                case 5:
                    return "baseline";
                case 6:
                    return "start";
                case 7:
                    return "end";
                default:
                    return SessionMonitorEngine.PUBLIC_DATA_UNDIFNED;
            }
        }
        return (String) invokeI.objValue;
    }

    /* loaded from: classes.dex */
    public static class Constraint {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Layout layout;
        public HashMap<String, ConstraintAttribute> mCustomConstraints;
        public int mViewId;
        public final Motion motion;
        public final PropertySet propertySet;
        public final Transform transform;

        public Constraint() {
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
            this.propertySet = new PropertySet();
            this.motion = new Motion();
            this.layout = new Layout();
            this.transform = new Transform();
            this.mCustomConstraints = new HashMap<>();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* renamed from: clone */
        public Constraint m2clone() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                Constraint constraint = new Constraint();
                constraint.layout.copyFrom(this.layout);
                constraint.motion.copyFrom(this.motion);
                constraint.propertySet.copyFrom(this.propertySet);
                constraint.transform.copyFrom(this.transform);
                constraint.mViewId = this.mViewId;
                return constraint;
            }
            return (Constraint) invokeV.objValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void fillFrom(int i, ConstraintLayout.LayoutParams layoutParams) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(65544, this, i, layoutParams) == null) {
                this.mViewId = i;
                Layout layout = this.layout;
                layout.leftToLeft = layoutParams.leftToLeft;
                layout.leftToRight = layoutParams.leftToRight;
                layout.rightToLeft = layoutParams.rightToLeft;
                layout.rightToRight = layoutParams.rightToRight;
                layout.topToTop = layoutParams.topToTop;
                layout.topToBottom = layoutParams.topToBottom;
                layout.bottomToTop = layoutParams.bottomToTop;
                layout.bottomToBottom = layoutParams.bottomToBottom;
                layout.baselineToBaseline = layoutParams.baselineToBaseline;
                layout.startToEnd = layoutParams.startToEnd;
                layout.startToStart = layoutParams.startToStart;
                layout.endToStart = layoutParams.endToStart;
                layout.endToEnd = layoutParams.endToEnd;
                layout.horizontalBias = layoutParams.horizontalBias;
                layout.verticalBias = layoutParams.verticalBias;
                layout.dimensionRatio = layoutParams.dimensionRatio;
                layout.circleConstraint = layoutParams.circleConstraint;
                layout.circleRadius = layoutParams.circleRadius;
                layout.circleAngle = layoutParams.circleAngle;
                layout.editorAbsoluteX = layoutParams.editorAbsoluteX;
                layout.editorAbsoluteY = layoutParams.editorAbsoluteY;
                layout.orientation = layoutParams.orientation;
                layout.guidePercent = layoutParams.guidePercent;
                layout.guideBegin = layoutParams.guideBegin;
                layout.guideEnd = layoutParams.guideEnd;
                layout.mWidth = ((ViewGroup.MarginLayoutParams) layoutParams).width;
                layout.mHeight = ((ViewGroup.MarginLayoutParams) layoutParams).height;
                layout.leftMargin = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                layout.rightMargin = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                layout.topMargin = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                layout.bottomMargin = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                layout.verticalWeight = layoutParams.verticalWeight;
                layout.horizontalWeight = layoutParams.horizontalWeight;
                layout.verticalChainStyle = layoutParams.verticalChainStyle;
                layout.horizontalChainStyle = layoutParams.horizontalChainStyle;
                layout.constrainedWidth = layoutParams.constrainedWidth;
                layout.constrainedHeight = layoutParams.constrainedHeight;
                layout.widthDefault = layoutParams.matchConstraintDefaultWidth;
                layout.heightDefault = layoutParams.matchConstraintDefaultHeight;
                layout.widthMax = layoutParams.matchConstraintMaxWidth;
                layout.heightMax = layoutParams.matchConstraintMaxHeight;
                layout.widthMin = layoutParams.matchConstraintMinWidth;
                layout.heightMin = layoutParams.matchConstraintMinHeight;
                layout.widthPercent = layoutParams.matchConstraintPercentWidth;
                layout.heightPercent = layoutParams.matchConstraintPercentHeight;
                layout.mConstraintTag = layoutParams.constraintTag;
                layout.goneTopMargin = layoutParams.goneTopMargin;
                layout.goneBottomMargin = layoutParams.goneBottomMargin;
                layout.goneLeftMargin = layoutParams.goneLeftMargin;
                layout.goneRightMargin = layoutParams.goneRightMargin;
                layout.goneStartMargin = layoutParams.goneStartMargin;
                layout.goneEndMargin = layoutParams.goneEndMargin;
                if (Build.VERSION.SDK_INT >= 17) {
                    layout.endMargin = layoutParams.getMarginEnd();
                    this.layout.startMargin = layoutParams.getMarginStart();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void fillFromConstraints(int i, Constraints.LayoutParams layoutParams) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(65545, this, i, layoutParams) == null) {
                fillFrom(i, layoutParams);
                this.propertySet.alpha = layoutParams.alpha;
                Transform transform = this.transform;
                transform.rotation = layoutParams.rotation;
                transform.rotationX = layoutParams.rotationX;
                transform.rotationY = layoutParams.rotationY;
                transform.scaleX = layoutParams.scaleX;
                transform.scaleY = layoutParams.scaleY;
                transform.transformPivotX = layoutParams.transformPivotX;
                transform.transformPivotY = layoutParams.transformPivotY;
                transform.translationX = layoutParams.translationX;
                transform.translationY = layoutParams.translationY;
                transform.translationZ = layoutParams.translationZ;
                transform.elevation = layoutParams.elevation;
                transform.applyElevation = layoutParams.applyElevation;
            }
        }

        private ConstraintAttribute get(String str, ConstraintAttribute.AttributeType attributeType) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, this, str, attributeType)) == null) {
                if (this.mCustomConstraints.containsKey(str)) {
                    ConstraintAttribute constraintAttribute = this.mCustomConstraints.get(str);
                    if (constraintAttribute.getType() != attributeType) {
                        throw new IllegalArgumentException("ConstraintAttribute is already a " + constraintAttribute.getType().name());
                    }
                    return constraintAttribute;
                }
                ConstraintAttribute constraintAttribute2 = new ConstraintAttribute(str, attributeType);
                this.mCustomConstraints.put(str, constraintAttribute2);
                return constraintAttribute2;
            }
            return (ConstraintAttribute) invokeLL.objValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void fillFromConstraints(ConstraintHelper constraintHelper, int i, Constraints.LayoutParams layoutParams) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(65546, this, constraintHelper, i, layoutParams) == null) {
                fillFromConstraints(i, layoutParams);
                if (constraintHelper instanceof Barrier) {
                    Layout layout = this.layout;
                    layout.mHelperType = 1;
                    Barrier barrier = (Barrier) constraintHelper;
                    layout.mBarrierDirection = barrier.getType();
                    this.layout.mReferenceIds = barrier.getReferencedIds();
                    this.layout.mBarrierMargin = barrier.getMargin();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setColorValue(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(65548, this, str, i) == null) {
                get(str, ConstraintAttribute.AttributeType.COLOR_TYPE).setColorValue(i);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFloatValue(String str, float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(65549, this, str, f) == null) {
                get(str, ConstraintAttribute.AttributeType.FLOAT_TYPE).setFloatValue(f);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIntValue(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(65550, this, str, i) == null) {
                get(str, ConstraintAttribute.AttributeType.INT_TYPE).setIntValue(i);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStringValue(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65551, this, str, str2) == null) {
                get(str, ConstraintAttribute.AttributeType.STRING_TYPE).setStringValue(str2);
            }
        }

        public void applyTo(ConstraintLayout.LayoutParams layoutParams) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, layoutParams) == null) {
                Layout layout = this.layout;
                layoutParams.leftToLeft = layout.leftToLeft;
                layoutParams.leftToRight = layout.leftToRight;
                layoutParams.rightToLeft = layout.rightToLeft;
                layoutParams.rightToRight = layout.rightToRight;
                layoutParams.topToTop = layout.topToTop;
                layoutParams.topToBottom = layout.topToBottom;
                layoutParams.bottomToTop = layout.bottomToTop;
                layoutParams.bottomToBottom = layout.bottomToBottom;
                layoutParams.baselineToBaseline = layout.baselineToBaseline;
                layoutParams.startToEnd = layout.startToEnd;
                layoutParams.startToStart = layout.startToStart;
                layoutParams.endToStart = layout.endToStart;
                layoutParams.endToEnd = layout.endToEnd;
                ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = layout.leftMargin;
                ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = layout.rightMargin;
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = layout.topMargin;
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = layout.bottomMargin;
                layoutParams.goneStartMargin = layout.goneStartMargin;
                layoutParams.goneEndMargin = layout.goneEndMargin;
                layoutParams.goneTopMargin = layout.goneTopMargin;
                layoutParams.goneBottomMargin = layout.goneBottomMargin;
                layoutParams.horizontalBias = layout.horizontalBias;
                layoutParams.verticalBias = layout.verticalBias;
                layoutParams.circleConstraint = layout.circleConstraint;
                layoutParams.circleRadius = layout.circleRadius;
                layoutParams.circleAngle = layout.circleAngle;
                layoutParams.dimensionRatio = layout.dimensionRatio;
                layoutParams.editorAbsoluteX = layout.editorAbsoluteX;
                layoutParams.editorAbsoluteY = layout.editorAbsoluteY;
                layoutParams.verticalWeight = layout.verticalWeight;
                layoutParams.horizontalWeight = layout.horizontalWeight;
                layoutParams.verticalChainStyle = layout.verticalChainStyle;
                layoutParams.horizontalChainStyle = layout.horizontalChainStyle;
                layoutParams.constrainedWidth = layout.constrainedWidth;
                layoutParams.constrainedHeight = layout.constrainedHeight;
                layoutParams.matchConstraintDefaultWidth = layout.widthDefault;
                layoutParams.matchConstraintDefaultHeight = layout.heightDefault;
                layoutParams.matchConstraintMaxWidth = layout.widthMax;
                layoutParams.matchConstraintMaxHeight = layout.heightMax;
                layoutParams.matchConstraintMinWidth = layout.widthMin;
                layoutParams.matchConstraintMinHeight = layout.heightMin;
                layoutParams.matchConstraintPercentWidth = layout.widthPercent;
                layoutParams.matchConstraintPercentHeight = layout.heightPercent;
                layoutParams.orientation = layout.orientation;
                layoutParams.guidePercent = layout.guidePercent;
                layoutParams.guideBegin = layout.guideBegin;
                layoutParams.guideEnd = layout.guideEnd;
                ((ViewGroup.MarginLayoutParams) layoutParams).width = layout.mWidth;
                ((ViewGroup.MarginLayoutParams) layoutParams).height = layout.mHeight;
                String str = layout.mConstraintTag;
                if (str != null) {
                    layoutParams.constraintTag = str;
                }
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams.setMarginStart(this.layout.startMargin);
                    layoutParams.setMarginEnd(this.layout.endMargin);
                }
                layoutParams.validate();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class Layout {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int BARRIER_ALLOWS_GONE_WIDGETS = 75;
        public static final int BARRIER_DIRECTION = 72;
        public static final int BARRIER_MARGIN = 73;
        public static final int BASELINE_TO_BASELINE = 1;
        public static final int BOTTOM_MARGIN = 2;
        public static final int BOTTOM_TO_BOTTOM = 3;
        public static final int BOTTOM_TO_TOP = 4;
        public static final int CHAIN_USE_RTL = 71;
        public static final int CIRCLE = 61;
        public static final int CIRCLE_ANGLE = 63;
        public static final int CIRCLE_RADIUS = 62;
        public static final int CONSTRAINT_REFERENCED_IDS = 74;
        public static final int DIMENSION_RATIO = 5;
        public static final int EDITOR_ABSOLUTE_X = 6;
        public static final int EDITOR_ABSOLUTE_Y = 7;
        public static final int END_MARGIN = 8;
        public static final int END_TO_END = 9;
        public static final int END_TO_START = 10;
        public static final int GONE_BOTTOM_MARGIN = 11;
        public static final int GONE_END_MARGIN = 12;
        public static final int GONE_LEFT_MARGIN = 13;
        public static final int GONE_RIGHT_MARGIN = 14;
        public static final int GONE_START_MARGIN = 15;
        public static final int GONE_TOP_MARGIN = 16;
        public static final int GUIDE_BEGIN = 17;
        public static final int GUIDE_END = 18;
        public static final int GUIDE_PERCENT = 19;
        public static final int HEIGHT_PERCENT = 70;
        public static final int HORIZONTAL_BIAS = 20;
        public static final int HORIZONTAL_STYLE = 39;
        public static final int HORIZONTAL_WEIGHT = 37;
        public static final int LAYOUT_HEIGHT = 21;
        public static final int LAYOUT_WIDTH = 22;
        public static final int LEFT_MARGIN = 23;
        public static final int LEFT_TO_LEFT = 24;
        public static final int LEFT_TO_RIGHT = 25;
        public static final int ORIENTATION = 26;
        public static final int RIGHT_MARGIN = 27;
        public static final int RIGHT_TO_LEFT = 28;
        public static final int RIGHT_TO_RIGHT = 29;
        public static final int START_MARGIN = 30;
        public static final int START_TO_END = 31;
        public static final int START_TO_START = 32;
        public static final int TOP_MARGIN = 33;
        public static final int TOP_TO_BOTTOM = 34;
        public static final int TOP_TO_TOP = 35;
        public static final int UNSET = -1;
        public static final int UNUSED = 76;
        public static final int VERTICAL_BIAS = 36;
        public static final int VERTICAL_STYLE = 40;
        public static final int VERTICAL_WEIGHT = 38;
        public static final int WIDTH_PERCENT = 69;
        public static SparseIntArray mapToConstant;
        public transient /* synthetic */ FieldHolder $fh;
        public int baselineToBaseline;
        public int bottomMargin;
        public int bottomToBottom;
        public int bottomToTop;
        public float circleAngle;
        public int circleConstraint;
        public int circleRadius;
        public boolean constrainedHeight;
        public boolean constrainedWidth;
        public String dimensionRatio;
        public int editorAbsoluteX;
        public int editorAbsoluteY;
        public int endMargin;
        public int endToEnd;
        public int endToStart;
        public int goneBottomMargin;
        public int goneEndMargin;
        public int goneLeftMargin;
        public int goneRightMargin;
        public int goneStartMargin;
        public int goneTopMargin;
        public int guideBegin;
        public int guideEnd;
        public float guidePercent;
        public int heightDefault;
        public int heightMax;
        public int heightMin;
        public float heightPercent;
        public float horizontalBias;
        public int horizontalChainStyle;
        public float horizontalWeight;
        public int leftMargin;
        public int leftToLeft;
        public int leftToRight;
        public boolean mApply;
        public boolean mBarrierAllowsGoneWidgets;
        public int mBarrierDirection;
        public int mBarrierMargin;
        public String mConstraintTag;
        public int mHeight;
        public int mHelperType;
        public boolean mIsGuideline;
        public String mReferenceIdString;
        public int[] mReferenceIds;
        public int mWidth;
        public int orientation;
        public int rightMargin;
        public int rightToLeft;
        public int rightToRight;
        public int startMargin;
        public int startToEnd;
        public int startToStart;
        public int topMargin;
        public int topToBottom;
        public int topToTop;
        public float verticalBias;
        public int verticalChainStyle;
        public float verticalWeight;
        public int widthDefault;
        public int widthMax;
        public int widthMin;
        public float widthPercent;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2116014485, "Landroidx/constraintlayout/widget/ConstraintSet$Layout;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2116014485, "Landroidx/constraintlayout/widget/ConstraintSet$Layout;");
                    return;
                }
            }
            SparseIntArray sparseIntArray = new SparseIntArray();
            mapToConstant = sparseIntArray;
            sparseIntArray.append(39, 24);
            mapToConstant.append(40, 25);
            mapToConstant.append(42, 28);
            mapToConstant.append(43, 29);
            mapToConstant.append(48, 35);
            mapToConstant.append(47, 34);
            mapToConstant.append(21, 4);
            mapToConstant.append(20, 3);
            mapToConstant.append(18, 1);
            mapToConstant.append(56, 6);
            mapToConstant.append(57, 7);
            mapToConstant.append(28, 17);
            mapToConstant.append(29, 18);
            mapToConstant.append(30, 19);
            mapToConstant.append(0, 26);
            mapToConstant.append(44, 31);
            mapToConstant.append(45, 32);
            mapToConstant.append(27, 10);
            mapToConstant.append(26, 9);
            mapToConstant.append(60, 13);
            mapToConstant.append(63, 16);
            mapToConstant.append(61, 14);
            mapToConstant.append(58, 11);
            mapToConstant.append(62, 15);
            mapToConstant.append(59, 12);
            mapToConstant.append(51, 38);
            mapToConstant.append(37, 37);
            mapToConstant.append(36, 39);
            mapToConstant.append(50, 40);
            mapToConstant.append(35, 20);
            mapToConstant.append(49, 36);
            mapToConstant.append(25, 5);
            mapToConstant.append(38, 76);
            mapToConstant.append(46, 76);
            mapToConstant.append(41, 76);
            mapToConstant.append(19, 76);
            mapToConstant.append(17, 76);
            mapToConstant.append(3, 23);
            mapToConstant.append(5, 27);
            mapToConstant.append(7, 30);
            mapToConstant.append(8, 8);
            mapToConstant.append(4, 33);
            mapToConstant.append(6, 2);
            mapToConstant.append(1, 22);
            mapToConstant.append(2, 21);
            mapToConstant.append(22, 61);
            mapToConstant.append(24, 62);
            mapToConstant.append(23, 63);
            mapToConstant.append(55, 69);
            mapToConstant.append(34, 70);
            mapToConstant.append(11, 71);
            mapToConstant.append(10, 72);
            mapToConstant.append(12, 73);
            mapToConstant.append(13, 74);
            mapToConstant.append(9, 75);
        }

        public Layout() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mIsGuideline = false;
            this.mApply = false;
            this.guideBegin = -1;
            this.guideEnd = -1;
            this.guidePercent = -1.0f;
            this.leftToLeft = -1;
            this.leftToRight = -1;
            this.rightToLeft = -1;
            this.rightToRight = -1;
            this.topToTop = -1;
            this.topToBottom = -1;
            this.bottomToTop = -1;
            this.bottomToBottom = -1;
            this.baselineToBaseline = -1;
            this.startToEnd = -1;
            this.startToStart = -1;
            this.endToStart = -1;
            this.endToEnd = -1;
            this.horizontalBias = 0.5f;
            this.verticalBias = 0.5f;
            this.dimensionRatio = null;
            this.circleConstraint = -1;
            this.circleRadius = 0;
            this.circleAngle = 0.0f;
            this.editorAbsoluteX = -1;
            this.editorAbsoluteY = -1;
            this.orientation = -1;
            this.leftMargin = -1;
            this.rightMargin = -1;
            this.topMargin = -1;
            this.bottomMargin = -1;
            this.endMargin = -1;
            this.startMargin = -1;
            this.goneLeftMargin = -1;
            this.goneTopMargin = -1;
            this.goneRightMargin = -1;
            this.goneBottomMargin = -1;
            this.goneEndMargin = -1;
            this.goneStartMargin = -1;
            this.verticalWeight = -1.0f;
            this.horizontalWeight = -1.0f;
            this.horizontalChainStyle = 0;
            this.verticalChainStyle = 0;
            this.widthDefault = 0;
            this.heightDefault = 0;
            this.widthMax = -1;
            this.heightMax = -1;
            this.widthMin = -1;
            this.heightMin = -1;
            this.widthPercent = 1.0f;
            this.heightPercent = 1.0f;
            this.mBarrierDirection = -1;
            this.mBarrierMargin = 0;
            this.mHelperType = -1;
            this.constrainedWidth = false;
            this.constrainedHeight = false;
            this.mBarrierAllowsGoneWidgets = true;
        }

        public void copyFrom(Layout layout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, layout) == null) {
                this.mIsGuideline = layout.mIsGuideline;
                this.mWidth = layout.mWidth;
                this.mApply = layout.mApply;
                this.mHeight = layout.mHeight;
                this.guideBegin = layout.guideBegin;
                this.guideEnd = layout.guideEnd;
                this.guidePercent = layout.guidePercent;
                this.leftToLeft = layout.leftToLeft;
                this.leftToRight = layout.leftToRight;
                this.rightToLeft = layout.rightToLeft;
                this.rightToRight = layout.rightToRight;
                this.topToTop = layout.topToTop;
                this.topToBottom = layout.topToBottom;
                this.bottomToTop = layout.bottomToTop;
                this.bottomToBottom = layout.bottomToBottom;
                this.baselineToBaseline = layout.baselineToBaseline;
                this.startToEnd = layout.startToEnd;
                this.startToStart = layout.startToStart;
                this.endToStart = layout.endToStart;
                this.endToEnd = layout.endToEnd;
                this.horizontalBias = layout.horizontalBias;
                this.verticalBias = layout.verticalBias;
                this.dimensionRatio = layout.dimensionRatio;
                this.circleConstraint = layout.circleConstraint;
                this.circleRadius = layout.circleRadius;
                this.circleAngle = layout.circleAngle;
                this.editorAbsoluteX = layout.editorAbsoluteX;
                this.editorAbsoluteY = layout.editorAbsoluteY;
                this.orientation = layout.orientation;
                this.leftMargin = layout.leftMargin;
                this.rightMargin = layout.rightMargin;
                this.topMargin = layout.topMargin;
                this.bottomMargin = layout.bottomMargin;
                this.endMargin = layout.endMargin;
                this.startMargin = layout.startMargin;
                this.goneLeftMargin = layout.goneLeftMargin;
                this.goneTopMargin = layout.goneTopMargin;
                this.goneRightMargin = layout.goneRightMargin;
                this.goneBottomMargin = layout.goneBottomMargin;
                this.goneEndMargin = layout.goneEndMargin;
                this.goneStartMargin = layout.goneStartMargin;
                this.verticalWeight = layout.verticalWeight;
                this.horizontalWeight = layout.horizontalWeight;
                this.horizontalChainStyle = layout.horizontalChainStyle;
                this.verticalChainStyle = layout.verticalChainStyle;
                this.widthDefault = layout.widthDefault;
                this.heightDefault = layout.heightDefault;
                this.widthMax = layout.widthMax;
                this.heightMax = layout.heightMax;
                this.widthMin = layout.widthMin;
                this.heightMin = layout.heightMin;
                this.widthPercent = layout.widthPercent;
                this.heightPercent = layout.heightPercent;
                this.mBarrierDirection = layout.mBarrierDirection;
                this.mBarrierMargin = layout.mBarrierMargin;
                this.mHelperType = layout.mHelperType;
                this.mConstraintTag = layout.mConstraintTag;
                int[] iArr = layout.mReferenceIds;
                if (iArr != null) {
                    this.mReferenceIds = Arrays.copyOf(iArr, iArr.length);
                } else {
                    this.mReferenceIds = null;
                }
                this.mReferenceIdString = layout.mReferenceIdString;
                this.constrainedWidth = layout.constrainedWidth;
                this.constrainedHeight = layout.constrainedHeight;
                this.mBarrierAllowsGoneWidgets = layout.mBarrierAllowsGoneWidgets;
            }
        }

        public void dump(MotionScene motionScene, StringBuilder sb) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionScene, sb) == null) {
                Field[] declaredFields = Layout.class.getDeclaredFields();
                sb.append("\n");
                for (Field field : declaredFields) {
                    String name = field.getName();
                    if (!Modifier.isStatic(field.getModifiers())) {
                        try {
                            Object obj = field.get(this);
                            Class<?> type = field.getType();
                            if (type == Integer.TYPE) {
                                Integer num = (Integer) obj;
                                if (num.intValue() != -1) {
                                    Object lookUpConstraintName = motionScene.lookUpConstraintName(num.intValue());
                                    sb.append("    ");
                                    sb.append(name);
                                    sb.append(" = \"");
                                    sb.append(lookUpConstraintName == null ? num : lookUpConstraintName);
                                    sb.append("\"\n");
                                }
                            } else if (type == Float.TYPE) {
                                Float f = (Float) obj;
                                if (f.floatValue() != -1.0f) {
                                    sb.append("    ");
                                    sb.append(name);
                                    sb.append(" = \"");
                                    sb.append(f);
                                    sb.append("\"\n");
                                }
                            }
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        public void fillFromAttributeList(Context context, AttributeSet attributeSet) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, attributeSet) == null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Layout);
                this.mApply = true;
                int indexCount = obtainStyledAttributes.getIndexCount();
                for (int i = 0; i < indexCount; i++) {
                    int index = obtainStyledAttributes.getIndex(i);
                    int i2 = mapToConstant.get(index);
                    if (i2 != 80) {
                        if (i2 != 81) {
                            switch (i2) {
                                case 1:
                                    this.baselineToBaseline = ConstraintSet.lookupID(obtainStyledAttributes, index, this.baselineToBaseline);
                                    continue;
                                case 2:
                                    this.bottomMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.bottomMargin);
                                    continue;
                                case 3:
                                    this.bottomToBottom = ConstraintSet.lookupID(obtainStyledAttributes, index, this.bottomToBottom);
                                    continue;
                                case 4:
                                    this.bottomToTop = ConstraintSet.lookupID(obtainStyledAttributes, index, this.bottomToTop);
                                    continue;
                                case 5:
                                    this.dimensionRatio = obtainStyledAttributes.getString(index);
                                    continue;
                                case 6:
                                    this.editorAbsoluteX = obtainStyledAttributes.getDimensionPixelOffset(index, this.editorAbsoluteX);
                                    continue;
                                case 7:
                                    this.editorAbsoluteY = obtainStyledAttributes.getDimensionPixelOffset(index, this.editorAbsoluteY);
                                    continue;
                                case 8:
                                    if (Build.VERSION.SDK_INT >= 17) {
                                        this.endMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.endMargin);
                                        break;
                                    } else {
                                        continue;
                                    }
                                case 9:
                                    this.endToEnd = ConstraintSet.lookupID(obtainStyledAttributes, index, this.endToEnd);
                                    continue;
                                case 10:
                                    this.endToStart = ConstraintSet.lookupID(obtainStyledAttributes, index, this.endToStart);
                                    continue;
                                case 11:
                                    this.goneBottomMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneBottomMargin);
                                    continue;
                                case 12:
                                    this.goneEndMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneEndMargin);
                                    continue;
                                case 13:
                                    this.goneLeftMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneLeftMargin);
                                    continue;
                                case 14:
                                    this.goneRightMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneRightMargin);
                                    continue;
                                case 15:
                                    this.goneStartMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneStartMargin);
                                    continue;
                                case 16:
                                    this.goneTopMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneTopMargin);
                                    continue;
                                case 17:
                                    this.guideBegin = obtainStyledAttributes.getDimensionPixelOffset(index, this.guideBegin);
                                    continue;
                                case 18:
                                    this.guideEnd = obtainStyledAttributes.getDimensionPixelOffset(index, this.guideEnd);
                                    continue;
                                case 19:
                                    this.guidePercent = obtainStyledAttributes.getFloat(index, this.guidePercent);
                                    continue;
                                case 20:
                                    this.horizontalBias = obtainStyledAttributes.getFloat(index, this.horizontalBias);
                                    continue;
                                case 21:
                                    this.mHeight = obtainStyledAttributes.getLayoutDimension(index, this.mHeight);
                                    continue;
                                case 22:
                                    this.mWidth = obtainStyledAttributes.getLayoutDimension(index, this.mWidth);
                                    continue;
                                case 23:
                                    this.leftMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.leftMargin);
                                    continue;
                                case 24:
                                    this.leftToLeft = ConstraintSet.lookupID(obtainStyledAttributes, index, this.leftToLeft);
                                    continue;
                                case 25:
                                    this.leftToRight = ConstraintSet.lookupID(obtainStyledAttributes, index, this.leftToRight);
                                    continue;
                                case 26:
                                    this.orientation = obtainStyledAttributes.getInt(index, this.orientation);
                                    continue;
                                case 27:
                                    this.rightMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.rightMargin);
                                    continue;
                                case 28:
                                    this.rightToLeft = ConstraintSet.lookupID(obtainStyledAttributes, index, this.rightToLeft);
                                    continue;
                                case 29:
                                    this.rightToRight = ConstraintSet.lookupID(obtainStyledAttributes, index, this.rightToRight);
                                    continue;
                                case 30:
                                    if (Build.VERSION.SDK_INT >= 17) {
                                        this.startMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.startMargin);
                                        break;
                                    } else {
                                        continue;
                                    }
                                case 31:
                                    this.startToEnd = ConstraintSet.lookupID(obtainStyledAttributes, index, this.startToEnd);
                                    continue;
                                case 32:
                                    this.startToStart = ConstraintSet.lookupID(obtainStyledAttributes, index, this.startToStart);
                                    continue;
                                case 33:
                                    this.topMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.topMargin);
                                    continue;
                                case 34:
                                    this.topToBottom = ConstraintSet.lookupID(obtainStyledAttributes, index, this.topToBottom);
                                    continue;
                                case 35:
                                    this.topToTop = ConstraintSet.lookupID(obtainStyledAttributes, index, this.topToTop);
                                    continue;
                                case 36:
                                    this.verticalBias = obtainStyledAttributes.getFloat(index, this.verticalBias);
                                    continue;
                                case 37:
                                    this.horizontalWeight = obtainStyledAttributes.getFloat(index, this.horizontalWeight);
                                    continue;
                                case 38:
                                    this.verticalWeight = obtainStyledAttributes.getFloat(index, this.verticalWeight);
                                    continue;
                                case 39:
                                    this.horizontalChainStyle = obtainStyledAttributes.getInt(index, this.horizontalChainStyle);
                                    continue;
                                case 40:
                                    this.verticalChainStyle = obtainStyledAttributes.getInt(index, this.verticalChainStyle);
                                    continue;
                                default:
                                    switch (i2) {
                                        case 54:
                                            this.widthDefault = obtainStyledAttributes.getInt(index, this.widthDefault);
                                            continue;
                                        case 55:
                                            this.heightDefault = obtainStyledAttributes.getInt(index, this.heightDefault);
                                            continue;
                                        case 56:
                                            this.widthMax = obtainStyledAttributes.getDimensionPixelSize(index, this.widthMax);
                                            continue;
                                        case 57:
                                            this.heightMax = obtainStyledAttributes.getDimensionPixelSize(index, this.heightMax);
                                            continue;
                                        case 58:
                                            this.widthMin = obtainStyledAttributes.getDimensionPixelSize(index, this.widthMin);
                                            continue;
                                        case 59:
                                            this.heightMin = obtainStyledAttributes.getDimensionPixelSize(index, this.heightMin);
                                            continue;
                                        default:
                                            switch (i2) {
                                                case 61:
                                                    this.circleConstraint = ConstraintSet.lookupID(obtainStyledAttributes, index, this.circleConstraint);
                                                    continue;
                                                case 62:
                                                    this.circleRadius = obtainStyledAttributes.getDimensionPixelSize(index, this.circleRadius);
                                                    continue;
                                                case 63:
                                                    this.circleAngle = obtainStyledAttributes.getFloat(index, this.circleAngle);
                                                    continue;
                                                default:
                                                    switch (i2) {
                                                        case 69:
                                                            this.widthPercent = obtainStyledAttributes.getFloat(index, 1.0f);
                                                            continue;
                                                        case 70:
                                                            this.heightPercent = obtainStyledAttributes.getFloat(index, 1.0f);
                                                            continue;
                                                        case 71:
                                                            Log.e(ConstraintSet.TAG, "CURRENTLY UNSUPPORTED");
                                                            continue;
                                                        case 72:
                                                            this.mBarrierDirection = obtainStyledAttributes.getInt(index, this.mBarrierDirection);
                                                            continue;
                                                        case 73:
                                                            this.mBarrierMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.mBarrierMargin);
                                                            continue;
                                                        case 74:
                                                            this.mReferenceIdString = obtainStyledAttributes.getString(index);
                                                            continue;
                                                        case 75:
                                                            this.mBarrierAllowsGoneWidgets = obtainStyledAttributes.getBoolean(index, this.mBarrierAllowsGoneWidgets);
                                                            continue;
                                                        case 76:
                                                            Log.w(ConstraintSet.TAG, "unused attribute 0x" + Integer.toHexString(index) + "   " + mapToConstant.get(index));
                                                            continue;
                                                        case 77:
                                                            this.mConstraintTag = obtainStyledAttributes.getString(index);
                                                            continue;
                                                        default:
                                                            Log.w(ConstraintSet.TAG, "Unknown attribute 0x" + Integer.toHexString(index) + "   " + mapToConstant.get(index));
                                                            continue;
                                                            continue;
                                                            continue;
                                                            continue;
                                                    }
                                            }
                                    }
                            }
                        } else {
                            this.constrainedHeight = obtainStyledAttributes.getBoolean(index, this.constrainedHeight);
                        }
                    } else {
                        this.constrainedWidth = obtainStyledAttributes.getBoolean(index, this.constrainedWidth);
                    }
                }
                obtainStyledAttributes.recycle();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class Motion {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int ANIMATE_RELATIVE_TO = 5;
        public static final int MOTION_DRAW_PATH = 4;
        public static final int MOTION_STAGGER = 6;
        public static final int PATH_MOTION_ARC = 2;
        public static final int TRANSITION_EASING = 3;
        public static final int TRANSITION_PATH_ROTATE = 1;
        public static SparseIntArray mapToConstant;
        public transient /* synthetic */ FieldHolder $fh;
        public int mAnimateRelativeTo;
        public boolean mApply;
        public int mDrawPath;
        public float mMotionStagger;
        public int mPathMotionArc;
        public float mPathRotate;
        public String mTransitionEasing;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-895443319, "Landroidx/constraintlayout/widget/ConstraintSet$Motion;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-895443319, "Landroidx/constraintlayout/widget/ConstraintSet$Motion;");
                    return;
                }
            }
            SparseIntArray sparseIntArray = new SparseIntArray();
            mapToConstant = sparseIntArray;
            sparseIntArray.append(2, 1);
            mapToConstant.append(4, 2);
            mapToConstant.append(5, 3);
            mapToConstant.append(1, 4);
            mapToConstant.append(0, 5);
            mapToConstant.append(3, 6);
        }

        public Motion() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mApply = false;
            this.mAnimateRelativeTo = -1;
            this.mTransitionEasing = null;
            this.mPathMotionArc = -1;
            this.mDrawPath = 0;
            this.mMotionStagger = Float.NaN;
            this.mPathRotate = Float.NaN;
        }

        public void copyFrom(Motion motion) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, motion) == null) {
                this.mApply = motion.mApply;
                this.mAnimateRelativeTo = motion.mAnimateRelativeTo;
                this.mTransitionEasing = motion.mTransitionEasing;
                this.mPathMotionArc = motion.mPathMotionArc;
                this.mDrawPath = motion.mDrawPath;
                this.mPathRotate = motion.mPathRotate;
                this.mMotionStagger = motion.mMotionStagger;
            }
        }

        public void fillFromAttributeList(Context context, AttributeSet attributeSet) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, attributeSet) == null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Motion);
                this.mApply = true;
                int indexCount = obtainStyledAttributes.getIndexCount();
                for (int i = 0; i < indexCount; i++) {
                    int index = obtainStyledAttributes.getIndex(i);
                    switch (mapToConstant.get(index)) {
                        case 1:
                            this.mPathRotate = obtainStyledAttributes.getFloat(index, this.mPathRotate);
                            break;
                        case 2:
                            this.mPathMotionArc = obtainStyledAttributes.getInt(index, this.mPathMotionArc);
                            break;
                        case 3:
                            if (obtainStyledAttributes.peekValue(index).type == 3) {
                                this.mTransitionEasing = obtainStyledAttributes.getString(index);
                                break;
                            } else {
                                this.mTransitionEasing = Easing.NAMED_EASING[obtainStyledAttributes.getInteger(index, 0)];
                                break;
                            }
                        case 4:
                            this.mDrawPath = obtainStyledAttributes.getInt(index, 0);
                            break;
                        case 5:
                            this.mAnimateRelativeTo = ConstraintSet.lookupID(obtainStyledAttributes, index, this.mAnimateRelativeTo);
                            break;
                        case 6:
                            this.mMotionStagger = obtainStyledAttributes.getFloat(index, this.mMotionStagger);
                            break;
                    }
                }
                obtainStyledAttributes.recycle();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class PropertySet {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float alpha;
        public boolean mApply;
        public float mProgress;
        public int mVisibilityMode;
        public int visibility;

        public PropertySet() {
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
            this.mApply = false;
            this.visibility = 0;
            this.mVisibilityMode = 0;
            this.alpha = 1.0f;
            this.mProgress = Float.NaN;
        }

        public void copyFrom(PropertySet propertySet) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, propertySet) == null) {
                this.mApply = propertySet.mApply;
                this.visibility = propertySet.visibility;
                this.alpha = propertySet.alpha;
                this.mProgress = propertySet.mProgress;
                this.mVisibilityMode = propertySet.mVisibilityMode;
            }
        }

        public void fillFromAttributeList(Context context, AttributeSet attributeSet) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, attributeSet) == null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PropertySet);
                this.mApply = true;
                int indexCount = obtainStyledAttributes.getIndexCount();
                for (int i = 0; i < indexCount; i++) {
                    int index = obtainStyledAttributes.getIndex(i);
                    if (index == 1) {
                        this.alpha = obtainStyledAttributes.getFloat(index, this.alpha);
                    } else if (index == 0) {
                        this.visibility = obtainStyledAttributes.getInt(index, this.visibility);
                        this.visibility = ConstraintSet.VISIBILITY_FLAGS[this.visibility];
                    } else if (index == 4) {
                        this.mVisibilityMode = obtainStyledAttributes.getInt(index, this.mVisibilityMode);
                    } else if (index == 3) {
                        this.mProgress = obtainStyledAttributes.getFloat(index, this.mProgress);
                    }
                }
                obtainStyledAttributes.recycle();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class Transform {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int ELEVATION = 11;
        public static final int ROTATION = 1;
        public static final int ROTATION_X = 2;
        public static final int ROTATION_Y = 3;
        public static final int SCALE_X = 4;
        public static final int SCALE_Y = 5;
        public static final int TRANSFORM_PIVOT_X = 6;
        public static final int TRANSFORM_PIVOT_Y = 7;
        public static final int TRANSLATION_X = 8;
        public static final int TRANSLATION_Y = 9;
        public static final int TRANSLATION_Z = 10;
        public static SparseIntArray mapToConstant;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean applyElevation;
        public float elevation;
        public boolean mApply;
        public float rotation;
        public float rotationX;
        public float rotationY;
        public float scaleX;
        public float scaleY;
        public float transformPivotX;
        public float transformPivotY;
        public float translationX;
        public float translationY;
        public float translationZ;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1115347829, "Landroidx/constraintlayout/widget/ConstraintSet$Transform;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1115347829, "Landroidx/constraintlayout/widget/ConstraintSet$Transform;");
                    return;
                }
            }
            SparseIntArray sparseIntArray = new SparseIntArray();
            mapToConstant = sparseIntArray;
            sparseIntArray.append(6, 1);
            mapToConstant.append(7, 2);
            mapToConstant.append(8, 3);
            mapToConstant.append(4, 4);
            mapToConstant.append(5, 5);
            mapToConstant.append(0, 6);
            mapToConstant.append(1, 7);
            mapToConstant.append(2, 8);
            mapToConstant.append(3, 9);
            mapToConstant.append(9, 10);
            mapToConstant.append(10, 11);
        }

        public Transform() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mApply = false;
            this.rotation = 0.0f;
            this.rotationX = 0.0f;
            this.rotationY = 0.0f;
            this.scaleX = 1.0f;
            this.scaleY = 1.0f;
            this.transformPivotX = Float.NaN;
            this.transformPivotY = Float.NaN;
            this.translationX = 0.0f;
            this.translationY = 0.0f;
            this.translationZ = 0.0f;
            this.applyElevation = false;
            this.elevation = 0.0f;
        }

        public void copyFrom(Transform transform) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, transform) == null) {
                this.mApply = transform.mApply;
                this.rotation = transform.rotation;
                this.rotationX = transform.rotationX;
                this.rotationY = transform.rotationY;
                this.scaleX = transform.scaleX;
                this.scaleY = transform.scaleY;
                this.transformPivotX = transform.transformPivotX;
                this.transformPivotY = transform.transformPivotY;
                this.translationX = transform.translationX;
                this.translationY = transform.translationY;
                this.translationZ = transform.translationZ;
                this.applyElevation = transform.applyElevation;
                this.elevation = transform.elevation;
            }
        }

        public void fillFromAttributeList(Context context, AttributeSet attributeSet) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, attributeSet) == null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Transform);
                this.mApply = true;
                int indexCount = obtainStyledAttributes.getIndexCount();
                for (int i = 0; i < indexCount; i++) {
                    int index = obtainStyledAttributes.getIndex(i);
                    switch (mapToConstant.get(index)) {
                        case 1:
                            this.rotation = obtainStyledAttributes.getFloat(index, this.rotation);
                            break;
                        case 2:
                            this.rotationX = obtainStyledAttributes.getFloat(index, this.rotationX);
                            break;
                        case 3:
                            this.rotationY = obtainStyledAttributes.getFloat(index, this.rotationY);
                            break;
                        case 4:
                            this.scaleX = obtainStyledAttributes.getFloat(index, this.scaleX);
                            break;
                        case 5:
                            this.scaleY = obtainStyledAttributes.getFloat(index, this.scaleY);
                            break;
                        case 6:
                            this.transformPivotX = obtainStyledAttributes.getDimension(index, this.transformPivotX);
                            break;
                        case 7:
                            this.transformPivotY = obtainStyledAttributes.getDimension(index, this.transformPivotY);
                            break;
                        case 8:
                            this.translationX = obtainStyledAttributes.getDimension(index, this.translationX);
                            break;
                        case 9:
                            this.translationY = obtainStyledAttributes.getDimension(index, this.translationY);
                            break;
                        case 10:
                            if (Build.VERSION.SDK_INT >= 21) {
                                this.translationZ = obtainStyledAttributes.getDimension(index, this.translationZ);
                                break;
                            } else {
                                break;
                            }
                        case 11:
                            if (Build.VERSION.SDK_INT >= 21) {
                                this.applyElevation = true;
                                this.elevation = obtainStyledAttributes.getDimension(index, this.elevation);
                                break;
                            } else {
                                break;
                            }
                    }
                }
                obtainStyledAttributes.recycle();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-92014285, "Landroidx/constraintlayout/widget/ConstraintSet;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-92014285, "Landroidx/constraintlayout/widget/ConstraintSet;");
                return;
            }
        }
        VISIBILITY_FLAGS = new int[]{0, 4, 8};
        SparseIntArray sparseIntArray = new SparseIntArray();
        mapToConstant = sparseIntArray;
        sparseIntArray.append(58, 25);
        mapToConstant.append(59, 26);
        mapToConstant.append(61, 29);
        mapToConstant.append(62, 30);
        mapToConstant.append(67, 36);
        mapToConstant.append(66, 35);
        mapToConstant.append(40, 4);
        mapToConstant.append(39, 3);
        mapToConstant.append(37, 1);
        mapToConstant.append(75, 6);
        mapToConstant.append(76, 7);
        mapToConstant.append(47, 17);
        mapToConstant.append(48, 18);
        mapToConstant.append(49, 19);
        mapToConstant.append(0, 27);
        mapToConstant.append(63, 32);
        mapToConstant.append(64, 33);
        mapToConstant.append(46, 10);
        mapToConstant.append(45, 9);
        mapToConstant.append(79, 13);
        mapToConstant.append(82, 16);
        mapToConstant.append(80, 14);
        mapToConstant.append(77, 11);
        mapToConstant.append(81, 15);
        mapToConstant.append(78, 12);
        mapToConstant.append(70, 40);
        mapToConstant.append(56, 39);
        mapToConstant.append(55, 41);
        mapToConstant.append(69, 42);
        mapToConstant.append(54, 20);
        mapToConstant.append(68, 37);
        mapToConstant.append(44, 5);
        mapToConstant.append(57, 82);
        mapToConstant.append(65, 82);
        mapToConstant.append(60, 82);
        mapToConstant.append(38, 82);
        mapToConstant.append(36, 82);
        mapToConstant.append(5, 24);
        mapToConstant.append(7, 28);
        mapToConstant.append(23, 31);
        mapToConstant.append(24, 8);
        mapToConstant.append(6, 34);
        mapToConstant.append(8, 2);
        mapToConstant.append(3, 23);
        mapToConstant.append(4, 21);
        mapToConstant.append(2, 22);
        mapToConstant.append(13, 43);
        mapToConstant.append(26, 44);
        mapToConstant.append(21, 45);
        mapToConstant.append(22, 46);
        mapToConstant.append(20, 60);
        mapToConstant.append(18, 47);
        mapToConstant.append(19, 48);
        mapToConstant.append(14, 49);
        mapToConstant.append(15, 50);
        mapToConstant.append(16, 51);
        mapToConstant.append(17, 52);
        mapToConstant.append(25, 53);
        mapToConstant.append(71, 54);
        mapToConstant.append(50, 55);
        mapToConstant.append(72, 56);
        mapToConstant.append(51, 57);
        mapToConstant.append(73, 58);
        mapToConstant.append(52, 59);
        mapToConstant.append(41, 61);
        mapToConstant.append(43, 62);
        mapToConstant.append(42, 63);
        mapToConstant.append(29, 64);
        mapToConstant.append(107, 65);
        mapToConstant.append(83, 66);
        mapToConstant.append(108, 67);
        mapToConstant.append(104, 79);
        mapToConstant.append(1, 38);
        mapToConstant.append(103, 68);
        mapToConstant.append(74, 69);
        mapToConstant.append(53, 70);
        mapToConstant.append(30, 71);
        mapToConstant.append(28, 72);
        mapToConstant.append(31, 73);
        mapToConstant.append(32, 74);
        mapToConstant.append(27, 75);
        mapToConstant.append(105, 76);
        mapToConstant.append(102, 77);
        mapToConstant.append(109, 78);
        mapToConstant.append(35, 80);
        mapToConstant.append(34, 81);
    }

    public ConstraintSet() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mSavedAttributes = new HashMap<>();
        this.mForceId = true;
        this.mConstraints = new HashMap<>();
    }

    public int[] getKnownIds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            Integer[] numArr = (Integer[]) this.mConstraints.keySet().toArray(new Integer[0]);
            int length = numArr.length;
            int[] iArr = new int[length];
            for (int i = 0; i < length; i++) {
                iArr[i] = numArr[i].intValue();
            }
            return iArr;
        }
        return (int[]) invokeV.objValue;
    }

    public static int lookupID(TypedArray typedArray, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65545, null, typedArray, i, i2)) == null) {
            int resourceId = typedArray.getResourceId(i, i2);
            if (resourceId == -1) {
                return typedArray.getInt(i, -1);
            }
            return resourceId;
        }
        return invokeLII.intValue;
    }

    public void setColorValue(int i, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048648, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)}) == null) {
            get(i).setColorValue(str, i2);
        }
    }

    public void setFloatValue(int i, String str, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048653, this, new Object[]{Integer.valueOf(i), str, Float.valueOf(f)}) == null) {
            get(i).setFloatValue(str, f);
        }
    }

    public void setIntValue(int i, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048662, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)}) == null) {
            get(i).setIntValue(str, i2);
        }
    }

    public void setStringValue(int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048670, this, i, str, str2) == null) {
            get(i).setStringValue(str, str2);
        }
    }

    public HashMap<String, ConstraintAttribute> getCustomAttributeSet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            return this.mSavedAttributes;
        }
        return (HashMap) invokeV.objValue;
    }

    public boolean isForceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            return this.mForceId;
        }
        return invokeV.booleanValue;
    }

    private void addAttributes(ConstraintAttribute.AttributeType attributeType, String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, attributeType, strArr) == null) {
            for (int i = 0; i < strArr.length; i++) {
                if (this.mSavedAttributes.containsKey(strArr[i])) {
                    ConstraintAttribute constraintAttribute = this.mSavedAttributes.get(strArr[i]);
                    if (constraintAttribute.getType() != attributeType) {
                        throw new IllegalArgumentException("ConstraintAttribute is already a " + constraintAttribute.getType().name());
                    }
                } else {
                    this.mSavedAttributes.put(strArr[i], new ConstraintAttribute(strArr[i], attributeType));
                }
            }
        }
    }

    public void load(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048634, this, context, i) == null) {
            XmlResourceParser xml = context.getResources().getXml(i);
            try {
                for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                    if (eventType != 0) {
                        if (eventType != 2) {
                            continue;
                        } else {
                            String name = xml.getName();
                            Constraint fillFromAttributeList = fillFromAttributeList(context, Xml.asAttributeSet(xml));
                            if (name.equalsIgnoreCase("Guideline")) {
                                fillFromAttributeList.layout.mIsGuideline = true;
                            }
                            this.mConstraints.put(Integer.valueOf(fillFromAttributeList.mViewId), fillFromAttributeList);
                            continue;
                        }
                    } else {
                        xml.getName();
                        continue;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (XmlPullParserException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void parseColorAttributes(Constraint constraint, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048636, this, constraint, str) == null) {
            String[] split = str.split(",");
            for (int i = 0; i < split.length; i++) {
                String[] split2 = split[i].split("=");
                if (split2.length == 2) {
                    constraint.setColorValue(split2[0], Color.parseColor(split2[1]));
                } else {
                    Log.w(TAG, " Unable to parse " + split[i]);
                }
            }
        }
    }

    public void parseFloatAttributes(Constraint constraint, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048637, this, constraint, str) == null) {
            String[] split = str.split(",");
            for (int i = 0; i < split.length; i++) {
                String[] split2 = split[i].split("=");
                if (split2.length == 2) {
                    constraint.setFloatValue(split2[0], Float.parseFloat(split2[1]));
                } else {
                    Log.w(TAG, " Unable to parse " + split[i]);
                }
            }
        }
    }

    public void parseIntAttributes(Constraint constraint, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048638, this, constraint, str) == null) {
            String[] split = str.split(",");
            for (int i = 0; i < split.length; i++) {
                String[] split2 = split[i].split("=");
                if (split2.length == 2) {
                    constraint.setFloatValue(split2[0], Integer.decode(split2[1]).intValue());
                } else {
                    Log.w(TAG, " Unable to parse " + split[i]);
                }
            }
        }
    }

    private int[] convertReferenceString(View view2, String str) {
        InterceptResult invokeLL;
        int i;
        Object designInformation;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, this, view2, str)) == null) {
            String[] split = str.split(",");
            Context context = view2.getContext();
            int[] iArr = new int[split.length];
            int i2 = 0;
            int i3 = 0;
            while (i2 < split.length) {
                String trim = split[i2].trim();
                try {
                    i = R.id.class.getField(trim).getInt(null);
                } catch (Exception unused) {
                    i = 0;
                }
                if (i == 0) {
                    i = context.getResources().getIdentifier(trim, "id", context.getPackageName());
                }
                if (i == 0 && view2.isInEditMode() && (view2.getParent() instanceof ConstraintLayout) && (designInformation = ((ConstraintLayout) view2.getParent()).getDesignInformation(0, trim)) != null && (designInformation instanceof Integer)) {
                    i = ((Integer) designInformation).intValue();
                }
                iArr[i3] = i;
                i2++;
                i3++;
            }
            if (i3 != split.length) {
                return Arrays.copyOf(iArr, i3);
            }
            return iArr;
        }
        return (int[]) invokeLL.objValue;
    }

    public void clear(int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048597, this, i, i2) == null) && this.mConstraints.containsKey(Integer.valueOf(i))) {
            Constraint constraint = this.mConstraints.get(Integer.valueOf(i));
            switch (i2) {
                case 1:
                    Layout layout = constraint.layout;
                    layout.leftToRight = -1;
                    layout.leftToLeft = -1;
                    layout.leftMargin = -1;
                    layout.goneLeftMargin = -1;
                    return;
                case 2:
                    Layout layout2 = constraint.layout;
                    layout2.rightToRight = -1;
                    layout2.rightToLeft = -1;
                    layout2.rightMargin = -1;
                    layout2.goneRightMargin = -1;
                    return;
                case 3:
                    Layout layout3 = constraint.layout;
                    layout3.topToBottom = -1;
                    layout3.topToTop = -1;
                    layout3.topMargin = -1;
                    layout3.goneTopMargin = -1;
                    return;
                case 4:
                    Layout layout4 = constraint.layout;
                    layout4.bottomToTop = -1;
                    layout4.bottomToBottom = -1;
                    layout4.bottomMargin = -1;
                    layout4.goneBottomMargin = -1;
                    return;
                case 5:
                    constraint.layout.baselineToBaseline = -1;
                    return;
                case 6:
                    Layout layout5 = constraint.layout;
                    layout5.startToEnd = -1;
                    layout5.startToStart = -1;
                    layout5.startMargin = -1;
                    layout5.goneStartMargin = -1;
                    return;
                case 7:
                    Layout layout6 = constraint.layout;
                    layout6.endToStart = -1;
                    layout6.endToEnd = -1;
                    layout6.endMargin = -1;
                    layout6.goneEndMargin = -1;
                    return;
                default:
                    throw new IllegalArgumentException("unknown constraint");
            }
        }
    }

    public void dump(MotionScene motionScene, int... iArr) {
        HashSet hashSet;
        Integer[] numArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048622, this, motionScene, iArr) == null) {
            Set<Integer> keySet = this.mConstraints.keySet();
            if (iArr.length != 0) {
                hashSet = new HashSet();
                for (int i : iArr) {
                    hashSet.add(Integer.valueOf(i));
                }
            } else {
                hashSet = new HashSet(keySet);
            }
            System.out.println(hashSet.size() + " constraints");
            StringBuilder sb = new StringBuilder();
            for (Integer num : (Integer[]) hashSet.toArray(new Integer[0])) {
                sb.append("<Constraint id=");
                sb.append(num);
                sb.append(" \n");
                this.mConstraints.get(num).layout.dump(motionScene, sb);
                sb.append("/>\n");
            }
            System.out.println(sb.toString());
        }
    }

    private void createHorizontalChain(int i, int i2, int i3, int i4, int[] iArr, float[] fArr, int i5, int i6, int i7) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), iArr, fArr, Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)}) == null) {
            if (iArr.length >= 2) {
                if (fArr != null && fArr.length != iArr.length) {
                    throw new IllegalArgumentException("must have 2 or more widgets in a chain");
                }
                if (fArr != null) {
                    get(iArr[0]).layout.horizontalWeight = fArr[0];
                }
                get(iArr[0]).layout.horizontalChainStyle = i5;
                connect(iArr[0], i6, i, i2, -1);
                for (int i8 = 1; i8 < iArr.length; i8++) {
                    int i9 = iArr[i8];
                    int i10 = i8 - 1;
                    connect(iArr[i8], i6, iArr[i10], i7, -1);
                    connect(iArr[i10], i7, iArr[i8], i6, -1);
                    if (fArr != null) {
                        get(iArr[i8]).layout.horizontalWeight = fArr[i8];
                    }
                }
                connect(iArr[iArr.length - 1], i7, i3, i4, -1);
                return;
            }
            throw new IllegalArgumentException("must have 2 or more widgets in a chain");
        }
    }

    private Constraint fillFromAttributeList(Context context, AttributeSet attributeSet) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, this, context, attributeSet)) == null) {
            Constraint constraint = new Constraint();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Constraint);
            populateConstraint(context, constraint, obtainStyledAttributes);
            obtainStyledAttributes.recycle();
            return constraint;
        }
        return (Constraint) invokeLL.objValue;
    }

    public void applyToLayoutParams(int i, ConstraintLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048587, this, i, layoutParams) == null) && this.mConstraints.containsKey(Integer.valueOf(i))) {
            this.mConstraints.get(Integer.valueOf(i)).applyTo(layoutParams);
        }
    }

    public void centerHorizontally(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048590, this, i, i2) == null) {
            if (i2 == 0) {
                center(i, 0, 1, 0, 0, 2, 0, 0.5f);
            } else {
                center(i, i2, 2, 0, i2, 1, 0, 0.5f);
            }
        }
    }

    public void centerHorizontallyRtl(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048592, this, i, i2) == null) {
            if (i2 == 0) {
                center(i, 0, 6, 0, 0, 7, 0, 0.5f);
            } else {
                center(i, i2, 7, 0, i2, 6, 0, 0.5f);
            }
        }
    }

    public void centerVertically(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048594, this, i, i2) == null) {
            if (i2 == 0) {
                center(i, 0, 3, 0, 0, 4, 0, 0.5f);
            } else {
                center(i, i2, 4, 0, i2, 3, 0, 0.5f);
            }
        }
    }

    public void clone(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048598, this, context, i) == null) {
            clone((ConstraintLayout) LayoutInflater.from(context).inflate(i, (ViewGroup) null));
        }
    }

    public void constrainDefaultHeight(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048605, this, i, i2) == null) {
            get(i).layout.heightDefault = i2;
        }
    }

    public void constrainDefaultWidth(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048606, this, i, i2) == null) {
            get(i).layout.widthDefault = i2;
        }
    }

    public void constrainHeight(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048607, this, i, i2) == null) {
            get(i).layout.mHeight = i2;
        }
    }

    public void constrainMaxHeight(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048608, this, i, i2) == null) {
            get(i).layout.heightMax = i2;
        }
    }

    public void constrainMaxWidth(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048609, this, i, i2) == null) {
            get(i).layout.widthMax = i2;
        }
    }

    public void constrainMinHeight(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048610, this, i, i2) == null) {
            get(i).layout.heightMin = i2;
        }
    }

    public void constrainMinWidth(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048611, this, i, i2) == null) {
            get(i).layout.widthMin = i2;
        }
    }

    public void constrainPercentHeight(int i, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048612, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) {
            get(i).layout.heightPercent = f;
        }
    }

    public void constrainPercentWidth(int i, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) {
            get(i).layout.widthPercent = f;
        }
    }

    public void constrainWidth(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048614, this, i, i2) == null) {
            get(i).layout.mWidth = i2;
        }
    }

    public void constrainedHeight(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048615, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            get(i).layout.constrainedHeight = z;
        }
    }

    public void constrainedWidth(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048616, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            get(i).layout.constrainedWidth = z;
        }
    }

    public void create(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048617, this, i, i2) == null) {
            Layout layout = get(i).layout;
            layout.mIsGuideline = true;
            layout.orientation = i2;
        }
    }

    public void setAlpha(int i, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048645, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) {
            get(i).propertySet.alpha = f;
        }
    }

    public void setApplyElevation(int i, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048646, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) && Build.VERSION.SDK_INT >= 21) {
            get(i).transform.applyElevation = z;
        }
    }

    public void setBarrierType(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048647, this, i, i2) == null) {
            get(i).layout.mHelperType = i2;
        }
    }

    public void setDimensionRatio(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048649, this, i, str) == null) {
            get(i).layout.dimensionRatio = str;
        }
    }

    public void setEditorAbsoluteX(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048650, this, i, i2) == null) {
            get(i).layout.editorAbsoluteX = i2;
        }
    }

    public void setEditorAbsoluteY(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048651, this, i, i2) == null) {
            get(i).layout.editorAbsoluteY = i2;
        }
    }

    public void setGuidelineBegin(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048656, this, i, i2) == null) {
            get(i).layout.guideBegin = i2;
            get(i).layout.guideEnd = -1;
            get(i).layout.guidePercent = -1.0f;
        }
    }

    public void setGuidelineEnd(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048657, this, i, i2) == null) {
            get(i).layout.guideEnd = i2;
            get(i).layout.guideBegin = -1;
            get(i).layout.guidePercent = -1.0f;
        }
    }

    public void setHorizontalBias(int i, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048659, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) {
            get(i).layout.horizontalBias = f;
        }
    }

    public void setHorizontalChainStyle(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048660, this, i, i2) == null) {
            get(i).layout.horizontalChainStyle = i2;
        }
    }

    public void setHorizontalWeight(int i, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048661, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) {
            get(i).layout.horizontalWeight = f;
        }
    }

    public void setReferencedIds(int i, int... iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048664, this, i, iArr) == null) {
            get(i).layout.mReferenceIds = iArr;
        }
    }

    public void setRotation(int i, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048665, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) {
            get(i).transform.rotation = f;
        }
    }

    public void setRotationX(int i, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048666, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) {
            get(i).transform.rotationX = f;
        }
    }

    public void setRotationY(int i, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048667, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) {
            get(i).transform.rotationY = f;
        }
    }

    public void setScaleX(int i, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048668, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) {
            get(i).transform.scaleX = f;
        }
    }

    public void setScaleY(int i, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048669, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) {
            get(i).transform.scaleY = f;
        }
    }

    public void setTransformPivotX(int i, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048672, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) {
            get(i).transform.transformPivotX = f;
        }
    }

    public void setTransformPivotY(int i, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048673, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) {
            get(i).transform.transformPivotY = f;
        }
    }

    public void setTranslationX(int i, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048675, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) {
            get(i).transform.translationX = f;
        }
    }

    public void setTranslationY(int i, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048676, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) {
            get(i).transform.translationY = f;
        }
    }

    public void setTranslationZ(int i, float f) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048677, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) && Build.VERSION.SDK_INT >= 21) {
            get(i).transform.translationZ = f;
        }
    }

    public void setVerticalBias(int i, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048679, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) {
            get(i).layout.verticalBias = f;
        }
    }

    public void setVerticalChainStyle(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048680, this, i, i2) == null) {
            get(i).layout.verticalChainStyle = i2;
        }
    }

    public void setVerticalWeight(int i, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048681, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) {
            get(i).layout.verticalWeight = f;
        }
    }

    public void setVisibility(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048682, this, i, i2) == null) {
            get(i).propertySet.visibility = i2;
        }
    }

    public void setVisibilityMode(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048683, this, i, i2) == null) {
            get(i).propertySet.mVisibilityMode = i2;
        }
    }

    private Constraint get(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65544, this, i)) == null) {
            if (!this.mConstraints.containsKey(Integer.valueOf(i))) {
                this.mConstraints.put(Integer.valueOf(i), new Constraint());
            }
            return this.mConstraints.get(Integer.valueOf(i));
        }
        return (Constraint) invokeI.objValue;
    }

    public void clone(ConstraintSet constraintSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, constraintSet) == null) {
            this.mConstraints.clear();
            for (Integer num : constraintSet.mConstraints.keySet()) {
                this.mConstraints.put(num, constraintSet.mConstraints.get(num).m2clone());
            }
        }
    }

    private void populateConstraint(Context context, Constraint constraint, TypedArray typedArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, this, context, constraint, typedArray) == null) {
            int indexCount = typedArray.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArray.getIndex(i);
                if (index != 1 && 23 != index && 24 != index) {
                    constraint.motion.mApply = true;
                    constraint.layout.mApply = true;
                    constraint.propertySet.mApply = true;
                    constraint.transform.mApply = true;
                }
                switch (mapToConstant.get(index)) {
                    case 1:
                        Layout layout = constraint.layout;
                        layout.baselineToBaseline = lookupID(typedArray, index, layout.baselineToBaseline);
                        break;
                    case 2:
                        Layout layout2 = constraint.layout;
                        layout2.bottomMargin = typedArray.getDimensionPixelSize(index, layout2.bottomMargin);
                        break;
                    case 3:
                        Layout layout3 = constraint.layout;
                        layout3.bottomToBottom = lookupID(typedArray, index, layout3.bottomToBottom);
                        break;
                    case 4:
                        Layout layout4 = constraint.layout;
                        layout4.bottomToTop = lookupID(typedArray, index, layout4.bottomToTop);
                        break;
                    case 5:
                        constraint.layout.dimensionRatio = typedArray.getString(index);
                        break;
                    case 6:
                        Layout layout5 = constraint.layout;
                        layout5.editorAbsoluteX = typedArray.getDimensionPixelOffset(index, layout5.editorAbsoluteX);
                        break;
                    case 7:
                        Layout layout6 = constraint.layout;
                        layout6.editorAbsoluteY = typedArray.getDimensionPixelOffset(index, layout6.editorAbsoluteY);
                        break;
                    case 8:
                        if (Build.VERSION.SDK_INT >= 17) {
                            Layout layout7 = constraint.layout;
                            layout7.endMargin = typedArray.getDimensionPixelSize(index, layout7.endMargin);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        Layout layout8 = constraint.layout;
                        layout8.endToEnd = lookupID(typedArray, index, layout8.endToEnd);
                        break;
                    case 10:
                        Layout layout9 = constraint.layout;
                        layout9.endToStart = lookupID(typedArray, index, layout9.endToStart);
                        break;
                    case 11:
                        Layout layout10 = constraint.layout;
                        layout10.goneBottomMargin = typedArray.getDimensionPixelSize(index, layout10.goneBottomMargin);
                        break;
                    case 12:
                        Layout layout11 = constraint.layout;
                        layout11.goneEndMargin = typedArray.getDimensionPixelSize(index, layout11.goneEndMargin);
                        break;
                    case 13:
                        Layout layout12 = constraint.layout;
                        layout12.goneLeftMargin = typedArray.getDimensionPixelSize(index, layout12.goneLeftMargin);
                        break;
                    case 14:
                        Layout layout13 = constraint.layout;
                        layout13.goneRightMargin = typedArray.getDimensionPixelSize(index, layout13.goneRightMargin);
                        break;
                    case 15:
                        Layout layout14 = constraint.layout;
                        layout14.goneStartMargin = typedArray.getDimensionPixelSize(index, layout14.goneStartMargin);
                        break;
                    case 16:
                        Layout layout15 = constraint.layout;
                        layout15.goneTopMargin = typedArray.getDimensionPixelSize(index, layout15.goneTopMargin);
                        break;
                    case 17:
                        Layout layout16 = constraint.layout;
                        layout16.guideBegin = typedArray.getDimensionPixelOffset(index, layout16.guideBegin);
                        break;
                    case 18:
                        Layout layout17 = constraint.layout;
                        layout17.guideEnd = typedArray.getDimensionPixelOffset(index, layout17.guideEnd);
                        break;
                    case 19:
                        Layout layout18 = constraint.layout;
                        layout18.guidePercent = typedArray.getFloat(index, layout18.guidePercent);
                        break;
                    case 20:
                        Layout layout19 = constraint.layout;
                        layout19.horizontalBias = typedArray.getFloat(index, layout19.horizontalBias);
                        break;
                    case 21:
                        Layout layout20 = constraint.layout;
                        layout20.mHeight = typedArray.getLayoutDimension(index, layout20.mHeight);
                        break;
                    case 22:
                        PropertySet propertySet = constraint.propertySet;
                        propertySet.visibility = typedArray.getInt(index, propertySet.visibility);
                        PropertySet propertySet2 = constraint.propertySet;
                        propertySet2.visibility = VISIBILITY_FLAGS[propertySet2.visibility];
                        break;
                    case 23:
                        Layout layout21 = constraint.layout;
                        layout21.mWidth = typedArray.getLayoutDimension(index, layout21.mWidth);
                        break;
                    case 24:
                        Layout layout22 = constraint.layout;
                        layout22.leftMargin = typedArray.getDimensionPixelSize(index, layout22.leftMargin);
                        break;
                    case 25:
                        Layout layout23 = constraint.layout;
                        layout23.leftToLeft = lookupID(typedArray, index, layout23.leftToLeft);
                        break;
                    case 26:
                        Layout layout24 = constraint.layout;
                        layout24.leftToRight = lookupID(typedArray, index, layout24.leftToRight);
                        break;
                    case 27:
                        Layout layout25 = constraint.layout;
                        layout25.orientation = typedArray.getInt(index, layout25.orientation);
                        break;
                    case 28:
                        Layout layout26 = constraint.layout;
                        layout26.rightMargin = typedArray.getDimensionPixelSize(index, layout26.rightMargin);
                        break;
                    case 29:
                        Layout layout27 = constraint.layout;
                        layout27.rightToLeft = lookupID(typedArray, index, layout27.rightToLeft);
                        break;
                    case 30:
                        Layout layout28 = constraint.layout;
                        layout28.rightToRight = lookupID(typedArray, index, layout28.rightToRight);
                        break;
                    case 31:
                        if (Build.VERSION.SDK_INT >= 17) {
                            Layout layout29 = constraint.layout;
                            layout29.startMargin = typedArray.getDimensionPixelSize(index, layout29.startMargin);
                            break;
                        } else {
                            break;
                        }
                    case 32:
                        Layout layout30 = constraint.layout;
                        layout30.startToEnd = lookupID(typedArray, index, layout30.startToEnd);
                        break;
                    case 33:
                        Layout layout31 = constraint.layout;
                        layout31.startToStart = lookupID(typedArray, index, layout31.startToStart);
                        break;
                    case 34:
                        Layout layout32 = constraint.layout;
                        layout32.topMargin = typedArray.getDimensionPixelSize(index, layout32.topMargin);
                        break;
                    case 35:
                        Layout layout33 = constraint.layout;
                        layout33.topToBottom = lookupID(typedArray, index, layout33.topToBottom);
                        break;
                    case 36:
                        Layout layout34 = constraint.layout;
                        layout34.topToTop = lookupID(typedArray, index, layout34.topToTop);
                        break;
                    case 37:
                        Layout layout35 = constraint.layout;
                        layout35.verticalBias = typedArray.getFloat(index, layout35.verticalBias);
                        break;
                    case 38:
                        constraint.mViewId = typedArray.getResourceId(index, constraint.mViewId);
                        break;
                    case 39:
                        Layout layout36 = constraint.layout;
                        layout36.horizontalWeight = typedArray.getFloat(index, layout36.horizontalWeight);
                        break;
                    case 40:
                        Layout layout37 = constraint.layout;
                        layout37.verticalWeight = typedArray.getFloat(index, layout37.verticalWeight);
                        break;
                    case 41:
                        Layout layout38 = constraint.layout;
                        layout38.horizontalChainStyle = typedArray.getInt(index, layout38.horizontalChainStyle);
                        break;
                    case 42:
                        Layout layout39 = constraint.layout;
                        layout39.verticalChainStyle = typedArray.getInt(index, layout39.verticalChainStyle);
                        break;
                    case 43:
                        PropertySet propertySet3 = constraint.propertySet;
                        propertySet3.alpha = typedArray.getFloat(index, propertySet3.alpha);
                        break;
                    case 44:
                        if (Build.VERSION.SDK_INT >= 21) {
                            Transform transform = constraint.transform;
                            transform.applyElevation = true;
                            transform.elevation = typedArray.getDimension(index, transform.elevation);
                            break;
                        } else {
                            break;
                        }
                    case 45:
                        Transform transform2 = constraint.transform;
                        transform2.rotationX = typedArray.getFloat(index, transform2.rotationX);
                        break;
                    case 46:
                        Transform transform3 = constraint.transform;
                        transform3.rotationY = typedArray.getFloat(index, transform3.rotationY);
                        break;
                    case 47:
                        Transform transform4 = constraint.transform;
                        transform4.scaleX = typedArray.getFloat(index, transform4.scaleX);
                        break;
                    case 48:
                        Transform transform5 = constraint.transform;
                        transform5.scaleY = typedArray.getFloat(index, transform5.scaleY);
                        break;
                    case 49:
                        Transform transform6 = constraint.transform;
                        transform6.transformPivotX = typedArray.getDimension(index, transform6.transformPivotX);
                        break;
                    case 50:
                        Transform transform7 = constraint.transform;
                        transform7.transformPivotY = typedArray.getDimension(index, transform7.transformPivotY);
                        break;
                    case 51:
                        Transform transform8 = constraint.transform;
                        transform8.translationX = typedArray.getDimension(index, transform8.translationX);
                        break;
                    case 52:
                        Transform transform9 = constraint.transform;
                        transform9.translationY = typedArray.getDimension(index, transform9.translationY);
                        break;
                    case 53:
                        if (Build.VERSION.SDK_INT >= 21) {
                            Transform transform10 = constraint.transform;
                            transform10.translationZ = typedArray.getDimension(index, transform10.translationZ);
                            break;
                        } else {
                            break;
                        }
                    case 54:
                        Layout layout40 = constraint.layout;
                        layout40.widthDefault = typedArray.getInt(index, layout40.widthDefault);
                        break;
                    case 55:
                        Layout layout41 = constraint.layout;
                        layout41.heightDefault = typedArray.getInt(index, layout41.heightDefault);
                        break;
                    case 56:
                        Layout layout42 = constraint.layout;
                        layout42.widthMax = typedArray.getDimensionPixelSize(index, layout42.widthMax);
                        break;
                    case 57:
                        Layout layout43 = constraint.layout;
                        layout43.heightMax = typedArray.getDimensionPixelSize(index, layout43.heightMax);
                        break;
                    case 58:
                        Layout layout44 = constraint.layout;
                        layout44.widthMin = typedArray.getDimensionPixelSize(index, layout44.widthMin);
                        break;
                    case 59:
                        Layout layout45 = constraint.layout;
                        layout45.heightMin = typedArray.getDimensionPixelSize(index, layout45.heightMin);
                        break;
                    case 60:
                        Transform transform11 = constraint.transform;
                        transform11.rotation = typedArray.getFloat(index, transform11.rotation);
                        break;
                    case 61:
                        Layout layout46 = constraint.layout;
                        layout46.circleConstraint = lookupID(typedArray, index, layout46.circleConstraint);
                        break;
                    case 62:
                        Layout layout47 = constraint.layout;
                        layout47.circleRadius = typedArray.getDimensionPixelSize(index, layout47.circleRadius);
                        break;
                    case 63:
                        Layout layout48 = constraint.layout;
                        layout48.circleAngle = typedArray.getFloat(index, layout48.circleAngle);
                        break;
                    case 64:
                        Motion motion = constraint.motion;
                        motion.mAnimateRelativeTo = lookupID(typedArray, index, motion.mAnimateRelativeTo);
                        break;
                    case 65:
                        if (typedArray.peekValue(index).type == 3) {
                            constraint.motion.mTransitionEasing = typedArray.getString(index);
                            break;
                        } else {
                            constraint.motion.mTransitionEasing = Easing.NAMED_EASING[typedArray.getInteger(index, 0)];
                            break;
                        }
                    case 66:
                        constraint.motion.mDrawPath = typedArray.getInt(index, 0);
                        break;
                    case 67:
                        Motion motion2 = constraint.motion;
                        motion2.mPathRotate = typedArray.getFloat(index, motion2.mPathRotate);
                        break;
                    case 68:
                        PropertySet propertySet4 = constraint.propertySet;
                        propertySet4.mProgress = typedArray.getFloat(index, propertySet4.mProgress);
                        break;
                    case 69:
                        constraint.layout.widthPercent = typedArray.getFloat(index, 1.0f);
                        break;
                    case 70:
                        constraint.layout.heightPercent = typedArray.getFloat(index, 1.0f);
                        break;
                    case 71:
                        Log.e(TAG, "CURRENTLY UNSUPPORTED");
                        break;
                    case 72:
                        Layout layout49 = constraint.layout;
                        layout49.mBarrierDirection = typedArray.getInt(index, layout49.mBarrierDirection);
                        break;
                    case 73:
                        Layout layout50 = constraint.layout;
                        layout50.mBarrierMargin = typedArray.getDimensionPixelSize(index, layout50.mBarrierMargin);
                        break;
                    case 74:
                        constraint.layout.mReferenceIdString = typedArray.getString(index);
                        break;
                    case 75:
                        Layout layout51 = constraint.layout;
                        layout51.mBarrierAllowsGoneWidgets = typedArray.getBoolean(index, layout51.mBarrierAllowsGoneWidgets);
                        break;
                    case 76:
                        Motion motion3 = constraint.motion;
                        motion3.mPathMotionArc = typedArray.getInt(index, motion3.mPathMotionArc);
                        break;
                    case 77:
                        constraint.layout.mConstraintTag = typedArray.getString(index);
                        break;
                    case 78:
                        PropertySet propertySet5 = constraint.propertySet;
                        propertySet5.mVisibilityMode = typedArray.getInt(index, propertySet5.mVisibilityMode);
                        break;
                    case 79:
                        Motion motion4 = constraint.motion;
                        motion4.mMotionStagger = typedArray.getFloat(index, motion4.mMotionStagger);
                        break;
                    case 80:
                        Layout layout52 = constraint.layout;
                        layout52.constrainedWidth = typedArray.getBoolean(index, layout52.constrainedWidth);
                        break;
                    case 81:
                        Layout layout53 = constraint.layout;
                        layout53.constrainedHeight = typedArray.getBoolean(index, layout53.constrainedHeight);
                        break;
                    case 82:
                        Log.w(TAG, "unused attribute 0x" + Integer.toHexString(index) + "   " + mapToConstant.get(index));
                        break;
                    default:
                        Log.w(TAG, "Unknown attribute 0x" + Integer.toHexString(index) + "   " + mapToConstant.get(index));
                        break;
                }
            }
        }
    }

    public static String[] splitString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            char[] charArray = str.toCharArray();
            ArrayList arrayList = new ArrayList();
            int i = 0;
            boolean z = false;
            for (int i2 = 0; i2 < charArray.length; i2++) {
                if (charArray[i2] == ',' && !z) {
                    arrayList.add(new String(charArray, i, i2 - i));
                    i = i2 + 1;
                } else if (charArray[i2] == '\"') {
                    z = !z;
                }
            }
            arrayList.add(new String(charArray, i, charArray.length - i));
            return (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        return (String[]) invokeL.objValue;
    }

    public void addColorAttributes(String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, strArr) == null) {
            addAttributes(ConstraintAttribute.AttributeType.COLOR_TYPE, strArr);
        }
    }

    public void addFloatAttributes(String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr) == null) {
            addAttributes(ConstraintAttribute.AttributeType.FLOAT_TYPE, strArr);
        }
    }

    public void addIntAttributes(String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, strArr) == null) {
            addAttributes(ConstraintAttribute.AttributeType.INT_TYPE, strArr);
        }
    }

    public void addStringAttributes(String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, strArr) == null) {
            addAttributes(ConstraintAttribute.AttributeType.STRING_TYPE, strArr);
        }
    }

    public void applyTo(ConstraintLayout constraintLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, constraintLayout) == null) {
            applyToInternal(constraintLayout, true);
            constraintLayout.setConstraintSet(null);
            constraintLayout.requestLayout();
        }
    }

    public void applyToWithoutCustom(ConstraintLayout constraintLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, constraintLayout) == null) {
            applyToInternal(constraintLayout, false);
            constraintLayout.setConstraintSet(null);
        }
    }

    public void clear(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.mConstraints.remove(Integer.valueOf(i));
        }
    }

    public boolean getApplyElevation(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048623, this, i)) == null) {
            return get(i).transform.applyElevation;
        }
        return invokeI.booleanValue;
    }

    public Constraint getConstraint(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048624, this, i)) == null) {
            if (this.mConstraints.containsKey(Integer.valueOf(i))) {
                return this.mConstraints.get(Integer.valueOf(i));
            }
            return null;
        }
        return (Constraint) invokeI.objValue;
    }

    public int getHeight(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048626, this, i)) == null) {
            return get(i).layout.mHeight;
        }
        return invokeI.intValue;
    }

    public Constraint getParameters(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048628, this, i)) == null) {
            return get(i);
        }
        return (Constraint) invokeI.objValue;
    }

    public int[] getReferencedIds(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048629, this, i)) == null) {
            int[] iArr = get(i).layout.mReferenceIds;
            if (iArr == null) {
                return new int[0];
            }
            return Arrays.copyOf(iArr, iArr.length);
        }
        return (int[]) invokeI.objValue;
    }

    public int getVisibility(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048630, this, i)) == null) {
            return get(i).propertySet.visibility;
        }
        return invokeI.intValue;
    }

    public int getVisibilityMode(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048631, this, i)) == null) {
            return get(i).propertySet.mVisibilityMode;
        }
        return invokeI.intValue;
    }

    public int getWidth(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048632, this, i)) == null) {
            return get(i).layout.mWidth;
        }
        return invokeI.intValue;
    }

    public void removeAttribute(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, str) == null) {
            this.mSavedAttributes.remove(str);
        }
    }

    public void setForceId(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048654, this, z) == null) {
            this.mForceId = z;
        }
    }

    public void setValidateOnParse(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048678, this, z) == null) {
            this.mValidate = z;
        }
    }

    public void addToHorizontalChain(int i, int i2, int i3) {
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048580, this, i, i2, i3) == null) {
            if (i2 == 0) {
                i4 = 1;
            } else {
                i4 = 2;
            }
            connect(i, 1, i2, i4, 0);
            if (i3 == 0) {
                i5 = 2;
            } else {
                i5 = 1;
            }
            connect(i, 2, i3, i5, 0);
            if (i2 != 0) {
                connect(i2, 2, i, 1, 0);
            }
            if (i3 != 0) {
                connect(i3, 1, i, 2, 0);
            }
        }
    }

    public void addToHorizontalChainRTL(int i, int i2, int i3) {
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048581, this, i, i2, i3) == null) {
            if (i2 == 0) {
                i4 = 6;
            } else {
                i4 = 7;
            }
            connect(i, 6, i2, i4, 0);
            if (i3 == 0) {
                i5 = 7;
            } else {
                i5 = 6;
            }
            connect(i, 7, i3, i5, 0);
            if (i2 != 0) {
                connect(i2, 7, i, 6, 0);
            }
            if (i3 != 0) {
                connect(i3, 6, i, 7, 0);
            }
        }
    }

    public void addToVerticalChain(int i, int i2, int i3) {
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048582, this, i, i2, i3) == null) {
            if (i2 == 0) {
                i4 = 3;
            } else {
                i4 = 4;
            }
            connect(i, 3, i2, i4, 0);
            if (i3 == 0) {
                i5 = 4;
            } else {
                i5 = 3;
            }
            connect(i, 4, i3, i5, 0);
            if (i2 != 0) {
                connect(i2, 4, i, 3, 0);
            }
            if (i3 != 0) {
                connect(i3, 3, i, 4, 0);
            }
        }
    }

    public void setTransformPivot(int i, float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048671, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Float.valueOf(f2)}) == null) {
            Transform transform = get(i).transform;
            transform.transformPivotY = f2;
            transform.transformPivotX = f;
        }
    }

    public void setTranslation(int i, float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048674, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Float.valueOf(f2)}) == null) {
            Transform transform = get(i).transform;
            transform.translationX = f;
            transform.translationY = f2;
        }
    }

    public void applyCustomAttributes(ConstraintLayout constraintLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, constraintLayout) == null) {
            int childCount = constraintLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = constraintLayout.getChildAt(i);
                int id = childAt.getId();
                if (!this.mConstraints.containsKey(Integer.valueOf(id))) {
                    Log.v(TAG, "id unknown " + Debug.getName(childAt));
                } else if (this.mForceId && id == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                } else {
                    if (this.mConstraints.containsKey(Integer.valueOf(id))) {
                        ConstraintAttribute.setAttributes(childAt, this.mConstraints.get(Integer.valueOf(id)).mCustomConstraints);
                    }
                }
            }
        }
    }

    public void clone(Constraints constraints) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, constraints) == null) {
            int childCount = constraints.getChildCount();
            this.mConstraints.clear();
            for (int i = 0; i < childCount; i++) {
                View childAt = constraints.getChildAt(i);
                Constraints.LayoutParams layoutParams = (Constraints.LayoutParams) childAt.getLayoutParams();
                int id = childAt.getId();
                if (this.mForceId && id == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (!this.mConstraints.containsKey(Integer.valueOf(id))) {
                    this.mConstraints.put(Integer.valueOf(id), new Constraint());
                }
                Constraint constraint = this.mConstraints.get(Integer.valueOf(id));
                if (childAt instanceof ConstraintHelper) {
                    constraint.fillFromConstraints((ConstraintHelper) childAt, id, layoutParams);
                }
                constraint.fillFromConstraints(id, layoutParams);
            }
        }
    }

    public void removeFromVerticalChain(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048644, this, i) == null) {
            if (this.mConstraints.containsKey(Integer.valueOf(i))) {
                Constraint constraint = this.mConstraints.get(Integer.valueOf(i));
                Layout layout = constraint.layout;
                int i2 = layout.topToBottom;
                int i3 = layout.bottomToTop;
                if (i2 != -1 || i3 != -1) {
                    if (i2 != -1 && i3 != -1) {
                        connect(i2, 4, i3, 3, 0);
                        connect(i3, 3, i2, 4, 0);
                    } else if (i2 != -1 || i3 != -1) {
                        Layout layout2 = constraint.layout;
                        int i4 = layout2.bottomToBottom;
                        if (i4 != -1) {
                            connect(i2, 4, i4, 4, 0);
                        } else {
                            int i5 = layout2.topToTop;
                            if (i5 != -1) {
                                connect(i3, 3, i5, 3, 0);
                            }
                        }
                    }
                }
            }
            clear(i, 3);
            clear(i, 4);
        }
    }

    public void applyToHelper(ConstraintHelper constraintHelper, ConstraintWidget constraintWidget, ConstraintLayout.LayoutParams layoutParams, SparseArray<ConstraintWidget> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048585, this, constraintHelper, constraintWidget, layoutParams, sparseArray) == null) {
            int id = constraintHelper.getId();
            if (this.mConstraints.containsKey(Integer.valueOf(id))) {
                Constraint constraint = this.mConstraints.get(Integer.valueOf(id));
                if (constraintWidget instanceof HelperWidget) {
                    constraintHelper.loadParameters(constraint, (HelperWidget) constraintWidget, layoutParams, sparseArray);
                }
            }
        }
    }

    public void constrainCircle(int i, int i2, int i3, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048604, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f)}) == null) {
            Layout layout = get(i).layout;
            layout.circleConstraint = i2;
            layout.circleRadius = i3;
            layout.circleAngle = f;
        }
    }

    public void createBarrier(int i, int i2, int i3, int... iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048618, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), iArr}) == null) {
            Layout layout = get(i).layout;
            layout.mHelperType = 1;
            layout.mBarrierDirection = i2;
            layout.mBarrierMargin = i3;
            layout.mIsGuideline = false;
            layout.mReferenceIds = iArr;
        }
    }

    public void applyToInternal(ConstraintLayout constraintLayout, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, constraintLayout, z) == null) {
            int childCount = constraintLayout.getChildCount();
            HashSet hashSet = new HashSet(this.mConstraints.keySet());
            for (int i = 0; i < childCount; i++) {
                View childAt = constraintLayout.getChildAt(i);
                int id = childAt.getId();
                if (!this.mConstraints.containsKey(Integer.valueOf(id))) {
                    Log.w(TAG, "id unknown " + Debug.getName(childAt));
                } else if (this.mForceId && id == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                } else {
                    if (id != -1) {
                        if (this.mConstraints.containsKey(Integer.valueOf(id))) {
                            hashSet.remove(Integer.valueOf(id));
                            Constraint constraint = this.mConstraints.get(Integer.valueOf(id));
                            if (childAt instanceof Barrier) {
                                constraint.layout.mHelperType = 1;
                            }
                            int i2 = constraint.layout.mHelperType;
                            if (i2 != -1 && i2 == 1) {
                                Barrier barrier = (Barrier) childAt;
                                barrier.setId(id);
                                barrier.setType(constraint.layout.mBarrierDirection);
                                barrier.setMargin(constraint.layout.mBarrierMargin);
                                barrier.setAllowsGoneWidget(constraint.layout.mBarrierAllowsGoneWidgets);
                                Layout layout = constraint.layout;
                                int[] iArr = layout.mReferenceIds;
                                if (iArr != null) {
                                    barrier.setReferencedIds(iArr);
                                } else {
                                    String str = layout.mReferenceIdString;
                                    if (str != null) {
                                        layout.mReferenceIds = convertReferenceString(barrier, str);
                                        barrier.setReferencedIds(constraint.layout.mReferenceIds);
                                    }
                                }
                            }
                            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
                            layoutParams.validate();
                            constraint.applyTo(layoutParams);
                            if (z) {
                                ConstraintAttribute.setAttributes(childAt, constraint.mCustomConstraints);
                            }
                            childAt.setLayoutParams(layoutParams);
                            PropertySet propertySet = constraint.propertySet;
                            if (propertySet.mVisibilityMode == 0) {
                                childAt.setVisibility(propertySet.visibility);
                            }
                            if (Build.VERSION.SDK_INT >= 17) {
                                childAt.setAlpha(constraint.propertySet.alpha);
                                childAt.setRotation(constraint.transform.rotation);
                                childAt.setRotationX(constraint.transform.rotationX);
                                childAt.setRotationY(constraint.transform.rotationY);
                                childAt.setScaleX(constraint.transform.scaleX);
                                childAt.setScaleY(constraint.transform.scaleY);
                                if (!Float.isNaN(constraint.transform.transformPivotX)) {
                                    childAt.setPivotX(constraint.transform.transformPivotX);
                                }
                                if (!Float.isNaN(constraint.transform.transformPivotY)) {
                                    childAt.setPivotY(constraint.transform.transformPivotY);
                                }
                                childAt.setTranslationX(constraint.transform.translationX);
                                childAt.setTranslationY(constraint.transform.translationY);
                                if (Build.VERSION.SDK_INT >= 21) {
                                    childAt.setTranslationZ(constraint.transform.translationZ);
                                    Transform transform = constraint.transform;
                                    if (transform.applyElevation) {
                                        childAt.setElevation(transform.elevation);
                                    }
                                }
                            }
                        } else {
                            Log.v(TAG, "WARNING NO CONSTRAINTS for view " + id);
                        }
                    }
                }
            }
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                Integer num = (Integer) it.next();
                Constraint constraint2 = this.mConstraints.get(num);
                int i3 = constraint2.layout.mHelperType;
                if (i3 != -1 && i3 == 1) {
                    Barrier barrier2 = new Barrier(constraintLayout.getContext());
                    barrier2.setId(num.intValue());
                    Layout layout2 = constraint2.layout;
                    int[] iArr2 = layout2.mReferenceIds;
                    if (iArr2 != null) {
                        barrier2.setReferencedIds(iArr2);
                    } else {
                        String str2 = layout2.mReferenceIdString;
                        if (str2 != null) {
                            layout2.mReferenceIds = convertReferenceString(barrier2, str2);
                            barrier2.setReferencedIds(constraint2.layout.mReferenceIds);
                        }
                    }
                    barrier2.setType(constraint2.layout.mBarrierDirection);
                    barrier2.setMargin(constraint2.layout.mBarrierMargin);
                    ConstraintLayout.LayoutParams generateDefaultLayoutParams = constraintLayout.generateDefaultLayoutParams();
                    barrier2.validateParams();
                    constraint2.applyTo(generateDefaultLayoutParams);
                    constraintLayout.addView(barrier2, generateDefaultLayoutParams);
                }
                if (constraint2.layout.mIsGuideline) {
                    View guideline = new Guideline(constraintLayout.getContext());
                    guideline.setId(num.intValue());
                    ConstraintLayout.LayoutParams generateDefaultLayoutParams2 = constraintLayout.generateDefaultLayoutParams();
                    constraint2.applyTo(generateDefaultLayoutParams2);
                    constraintLayout.addView(guideline, generateDefaultLayoutParams2);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x017f, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void load(Context context, XmlPullParser xmlPullParser) {
        Constraint fillFromAttributeList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048635, this, context, xmlPullParser) == null) {
            try {
                int eventType = xmlPullParser.getEventType();
                Constraint constraint = null;
                while (eventType != 1) {
                    if (eventType != 0) {
                        char c = 3;
                        if (eventType != 2) {
                            if (eventType != 3) {
                                continue;
                            } else {
                                String name = xmlPullParser.getName();
                                if (TAG.equals(name)) {
                                    return;
                                }
                                if (name.equalsIgnoreCase("Constraint")) {
                                    this.mConstraints.put(Integer.valueOf(constraint.mViewId), constraint);
                                    constraint = null;
                                }
                            }
                        } else {
                            String name2 = xmlPullParser.getName();
                            switch (name2.hashCode()) {
                                case -2025855158:
                                    if (name2.equals("Layout")) {
                                        c = 5;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case -1984451626:
                                    if (name2.equals("Motion")) {
                                        c = 6;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case -1269513683:
                                    if (name2.equals("PropertySet")) {
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case -1238332596:
                                    if (name2.equals("Transform")) {
                                        c = 4;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case -71750448:
                                    if (name2.equals("Guideline")) {
                                        c = 1;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 1331510167:
                                    if (name2.equals("Barrier")) {
                                        c = 2;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 1791837707:
                                    if (name2.equals("CustomAttribute")) {
                                        c = 7;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                case 1803088381:
                                    if (name2.equals("Constraint")) {
                                        c = 0;
                                        break;
                                    }
                                    c = 65535;
                                    break;
                                default:
                                    c = 65535;
                                    break;
                            }
                            switch (c) {
                                case 0:
                                    fillFromAttributeList = fillFromAttributeList(context, Xml.asAttributeSet(xmlPullParser));
                                    constraint = fillFromAttributeList;
                                    break;
                                case 1:
                                    fillFromAttributeList = fillFromAttributeList(context, Xml.asAttributeSet(xmlPullParser));
                                    fillFromAttributeList.layout.mIsGuideline = true;
                                    fillFromAttributeList.layout.mApply = true;
                                    constraint = fillFromAttributeList;
                                    break;
                                case 2:
                                    fillFromAttributeList = fillFromAttributeList(context, Xml.asAttributeSet(xmlPullParser));
                                    fillFromAttributeList.layout.mHelperType = 1;
                                    constraint = fillFromAttributeList;
                                    break;
                                case 3:
                                    if (constraint != null) {
                                        constraint.propertySet.fillFromAttributeList(context, Xml.asAttributeSet(xmlPullParser));
                                        break;
                                    } else {
                                        throw new RuntimeException(ERROR_MESSAGE + xmlPullParser.getLineNumber());
                                    }
                                case 4:
                                    if (constraint != null) {
                                        constraint.transform.fillFromAttributeList(context, Xml.asAttributeSet(xmlPullParser));
                                        break;
                                    } else {
                                        throw new RuntimeException(ERROR_MESSAGE + xmlPullParser.getLineNumber());
                                    }
                                case 5:
                                    if (constraint != null) {
                                        constraint.layout.fillFromAttributeList(context, Xml.asAttributeSet(xmlPullParser));
                                        break;
                                    } else {
                                        throw new RuntimeException(ERROR_MESSAGE + xmlPullParser.getLineNumber());
                                    }
                                case 6:
                                    if (constraint != null) {
                                        constraint.motion.fillFromAttributeList(context, Xml.asAttributeSet(xmlPullParser));
                                        break;
                                    } else {
                                        throw new RuntimeException(ERROR_MESSAGE + xmlPullParser.getLineNumber());
                                    }
                                case 7:
                                    if (constraint != null) {
                                        ConstraintAttribute.parse(context, xmlPullParser, constraint.mCustomConstraints);
                                        break;
                                    } else {
                                        throw new RuntimeException(ERROR_MESSAGE + xmlPullParser.getLineNumber());
                                    }
                            }
                        }
                    } else {
                        xmlPullParser.getName();
                    }
                    eventType = xmlPullParser.next();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (XmlPullParserException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void center(int i, int i2, int i3, int i4, int i5, int i6, int i7, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Float.valueOf(f)}) == null) {
            if (i4 >= 0) {
                if (i7 >= 0) {
                    if (f > 0.0f && f <= 1.0f) {
                        if (i3 != 1 && i3 != 2) {
                            if (i3 != 6 && i3 != 7) {
                                connect(i, 3, i2, i3, i4);
                                connect(i, 4, i5, i6, i7);
                                this.mConstraints.get(Integer.valueOf(i)).layout.verticalBias = f;
                                return;
                            }
                            connect(i, 6, i2, i3, i4);
                            connect(i, 7, i5, i6, i7);
                            this.mConstraints.get(Integer.valueOf(i)).layout.horizontalBias = f;
                            return;
                        }
                        connect(i, 1, i2, i3, i4);
                        connect(i, 2, i5, i6, i7);
                        this.mConstraints.get(Integer.valueOf(i)).layout.horizontalBias = f;
                        return;
                    }
                    throw new IllegalArgumentException("bias must be between 0 and 1 inclusive");
                }
                throw new IllegalArgumentException("margin must be > 0");
            }
            throw new IllegalArgumentException("margin must be > 0");
        }
    }

    public void centerHorizontally(int i, int i2, int i3, int i4, int i5, int i6, int i7, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Float.valueOf(f)}) == null) {
            connect(i, 1, i2, i3, i4);
            connect(i, 2, i5, i6, i7);
            this.mConstraints.get(Integer.valueOf(i)).layout.horizontalBias = f;
        }
    }

    public void centerHorizontallyRtl(int i, int i2, int i3, int i4, int i5, int i6, int i7, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Float.valueOf(f)}) == null) {
            connect(i, 6, i2, i3, i4);
            connect(i, 7, i5, i6, i7);
            this.mConstraints.get(Integer.valueOf(i)).layout.horizontalBias = f;
        }
    }

    public void centerVertically(int i, int i2, int i3, int i4, int i5, int i6, int i7, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Float.valueOf(f)}) == null) {
            connect(i, 3, i2, i3, i4);
            connect(i, 4, i5, i6, i7);
            this.mConstraints.get(Integer.valueOf(i)).layout.verticalBias = f;
        }
    }

    public void clone(ConstraintLayout constraintLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, constraintLayout) == null) {
            int childCount = constraintLayout.getChildCount();
            this.mConstraints.clear();
            for (int i = 0; i < childCount; i++) {
                View childAt = constraintLayout.getChildAt(i);
                ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
                int id = childAt.getId();
                if (this.mForceId && id == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (!this.mConstraints.containsKey(Integer.valueOf(id))) {
                    this.mConstraints.put(Integer.valueOf(id), new Constraint());
                }
                Constraint constraint = this.mConstraints.get(Integer.valueOf(id));
                constraint.mCustomConstraints = ConstraintAttribute.extractAttributes(this.mSavedAttributes, childAt);
                constraint.fillFrom(id, layoutParams);
                constraint.propertySet.visibility = childAt.getVisibility();
                if (Build.VERSION.SDK_INT >= 17) {
                    constraint.propertySet.alpha = childAt.getAlpha();
                    constraint.transform.rotation = childAt.getRotation();
                    constraint.transform.rotationX = childAt.getRotationX();
                    constraint.transform.rotationY = childAt.getRotationY();
                    constraint.transform.scaleX = childAt.getScaleX();
                    constraint.transform.scaleY = childAt.getScaleY();
                    float pivotX = childAt.getPivotX();
                    float pivotY = childAt.getPivotY();
                    if (pivotX != 0.0d || pivotY != 0.0d) {
                        Transform transform = constraint.transform;
                        transform.transformPivotX = pivotX;
                        transform.transformPivotY = pivotY;
                    }
                    constraint.transform.translationX = childAt.getTranslationX();
                    constraint.transform.translationY = childAt.getTranslationY();
                    if (Build.VERSION.SDK_INT >= 21) {
                        constraint.transform.translationZ = childAt.getTranslationZ();
                        Transform transform2 = constraint.transform;
                        if (transform2.applyElevation) {
                            transform2.elevation = childAt.getElevation();
                        }
                    }
                }
                if (childAt instanceof Barrier) {
                    Barrier barrier = (Barrier) childAt;
                    constraint.layout.mBarrierAllowsGoneWidgets = barrier.allowsGoneWidget();
                    constraint.layout.mReferenceIds = barrier.getReferencedIds();
                    constraint.layout.mBarrierDirection = barrier.getType();
                    constraint.layout.mBarrierMargin = barrier.getMargin();
                }
            }
        }
    }

    public void readFallback(ConstraintLayout constraintLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, constraintLayout) == null) {
            int childCount = constraintLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = constraintLayout.getChildAt(i);
                ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
                int id = childAt.getId();
                if (this.mForceId && id == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (!this.mConstraints.containsKey(Integer.valueOf(id))) {
                    this.mConstraints.put(Integer.valueOf(id), new Constraint());
                }
                Constraint constraint = this.mConstraints.get(Integer.valueOf(id));
                if (!constraint.layout.mApply) {
                    constraint.fillFrom(id, layoutParams);
                    if (childAt instanceof ConstraintHelper) {
                        constraint.layout.mReferenceIds = ((ConstraintHelper) childAt).getReferencedIds();
                        if (childAt instanceof Barrier) {
                            Barrier barrier = (Barrier) childAt;
                            constraint.layout.mBarrierAllowsGoneWidgets = barrier.allowsGoneWidget();
                            constraint.layout.mBarrierDirection = barrier.getType();
                            constraint.layout.mBarrierMargin = barrier.getMargin();
                        }
                    }
                    constraint.layout.mApply = true;
                }
                PropertySet propertySet = constraint.propertySet;
                if (!propertySet.mApply) {
                    propertySet.visibility = childAt.getVisibility();
                    constraint.propertySet.alpha = childAt.getAlpha();
                    constraint.propertySet.mApply = true;
                }
                if (Build.VERSION.SDK_INT >= 17) {
                    Transform transform = constraint.transform;
                    if (!transform.mApply) {
                        transform.mApply = true;
                        transform.rotation = childAt.getRotation();
                        constraint.transform.rotationX = childAt.getRotationX();
                        constraint.transform.rotationY = childAt.getRotationY();
                        constraint.transform.scaleX = childAt.getScaleX();
                        constraint.transform.scaleY = childAt.getScaleY();
                        float pivotX = childAt.getPivotX();
                        float pivotY = childAt.getPivotY();
                        if (pivotX != 0.0d || pivotY != 0.0d) {
                            Transform transform2 = constraint.transform;
                            transform2.transformPivotX = pivotX;
                            transform2.transformPivotY = pivotY;
                        }
                        constraint.transform.translationX = childAt.getTranslationX();
                        constraint.transform.translationY = childAt.getTranslationY();
                        if (Build.VERSION.SDK_INT >= 21) {
                            constraint.transform.translationZ = childAt.getTranslationZ();
                            Transform transform3 = constraint.transform;
                            if (transform3.applyElevation) {
                                transform3.elevation = childAt.getElevation();
                            }
                        }
                    }
                }
            }
        }
    }

    public void connect(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048602, this, i, i2, i3, i4) == null) {
            if (!this.mConstraints.containsKey(Integer.valueOf(i))) {
                this.mConstraints.put(Integer.valueOf(i), new Constraint());
            }
            Constraint constraint = this.mConstraints.get(Integer.valueOf(i));
            switch (i2) {
                case 1:
                    if (i4 == 1) {
                        Layout layout = constraint.layout;
                        layout.leftToLeft = i3;
                        layout.leftToRight = -1;
                        return;
                    } else if (i4 == 2) {
                        Layout layout2 = constraint.layout;
                        layout2.leftToRight = i3;
                        layout2.leftToLeft = -1;
                        return;
                    } else {
                        throw new IllegalArgumentException("left to " + sideToString(i4) + " undefined");
                    }
                case 2:
                    if (i4 == 1) {
                        Layout layout3 = constraint.layout;
                        layout3.rightToLeft = i3;
                        layout3.rightToRight = -1;
                        return;
                    } else if (i4 == 2) {
                        Layout layout4 = constraint.layout;
                        layout4.rightToRight = i3;
                        layout4.rightToLeft = -1;
                        return;
                    } else {
                        throw new IllegalArgumentException("right to " + sideToString(i4) + " undefined");
                    }
                case 3:
                    if (i4 == 3) {
                        Layout layout5 = constraint.layout;
                        layout5.topToTop = i3;
                        layout5.topToBottom = -1;
                        layout5.baselineToBaseline = -1;
                        return;
                    } else if (i4 == 4) {
                        Layout layout6 = constraint.layout;
                        layout6.topToBottom = i3;
                        layout6.topToTop = -1;
                        layout6.baselineToBaseline = -1;
                        return;
                    } else {
                        throw new IllegalArgumentException("right to " + sideToString(i4) + " undefined");
                    }
                case 4:
                    if (i4 == 4) {
                        Layout layout7 = constraint.layout;
                        layout7.bottomToBottom = i3;
                        layout7.bottomToTop = -1;
                        layout7.baselineToBaseline = -1;
                        return;
                    } else if (i4 == 3) {
                        Layout layout8 = constraint.layout;
                        layout8.bottomToTop = i3;
                        layout8.bottomToBottom = -1;
                        layout8.baselineToBaseline = -1;
                        return;
                    } else {
                        throw new IllegalArgumentException("right to " + sideToString(i4) + " undefined");
                    }
                case 5:
                    if (i4 == 5) {
                        Layout layout9 = constraint.layout;
                        layout9.baselineToBaseline = i3;
                        layout9.bottomToBottom = -1;
                        layout9.bottomToTop = -1;
                        layout9.topToTop = -1;
                        layout9.topToBottom = -1;
                        return;
                    }
                    throw new IllegalArgumentException("right to " + sideToString(i4) + " undefined");
                case 6:
                    if (i4 == 6) {
                        Layout layout10 = constraint.layout;
                        layout10.startToStart = i3;
                        layout10.startToEnd = -1;
                        return;
                    } else if (i4 == 7) {
                        Layout layout11 = constraint.layout;
                        layout11.startToEnd = i3;
                        layout11.startToStart = -1;
                        return;
                    } else {
                        throw new IllegalArgumentException("right to " + sideToString(i4) + " undefined");
                    }
                case 7:
                    if (i4 == 7) {
                        Layout layout12 = constraint.layout;
                        layout12.endToEnd = i3;
                        layout12.endToStart = -1;
                        return;
                    } else if (i4 == 6) {
                        Layout layout13 = constraint.layout;
                        layout13.endToStart = i3;
                        layout13.endToEnd = -1;
                        return;
                    } else {
                        throw new IllegalArgumentException("right to " + sideToString(i4) + " undefined");
                    }
                default:
                    throw new IllegalArgumentException(sideToString(i2) + " to " + sideToString(i4) + " unknown");
            }
        }
    }

    public void connect(int i, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            if (!this.mConstraints.containsKey(Integer.valueOf(i))) {
                this.mConstraints.put(Integer.valueOf(i), new Constraint());
            }
            Constraint constraint = this.mConstraints.get(Integer.valueOf(i));
            switch (i2) {
                case 1:
                    if (i4 == 1) {
                        Layout layout = constraint.layout;
                        layout.leftToLeft = i3;
                        layout.leftToRight = -1;
                    } else if (i4 == 2) {
                        Layout layout2 = constraint.layout;
                        layout2.leftToRight = i3;
                        layout2.leftToLeft = -1;
                    } else {
                        throw new IllegalArgumentException("Left to " + sideToString(i4) + " undefined");
                    }
                    constraint.layout.leftMargin = i5;
                    return;
                case 2:
                    if (i4 == 1) {
                        Layout layout3 = constraint.layout;
                        layout3.rightToLeft = i3;
                        layout3.rightToRight = -1;
                    } else if (i4 == 2) {
                        Layout layout4 = constraint.layout;
                        layout4.rightToRight = i3;
                        layout4.rightToLeft = -1;
                    } else {
                        throw new IllegalArgumentException("right to " + sideToString(i4) + " undefined");
                    }
                    constraint.layout.rightMargin = i5;
                    return;
                case 3:
                    if (i4 == 3) {
                        Layout layout5 = constraint.layout;
                        layout5.topToTop = i3;
                        layout5.topToBottom = -1;
                        layout5.baselineToBaseline = -1;
                    } else if (i4 == 4) {
                        Layout layout6 = constraint.layout;
                        layout6.topToBottom = i3;
                        layout6.topToTop = -1;
                        layout6.baselineToBaseline = -1;
                    } else {
                        throw new IllegalArgumentException("right to " + sideToString(i4) + " undefined");
                    }
                    constraint.layout.topMargin = i5;
                    return;
                case 4:
                    if (i4 == 4) {
                        Layout layout7 = constraint.layout;
                        layout7.bottomToBottom = i3;
                        layout7.bottomToTop = -1;
                        layout7.baselineToBaseline = -1;
                    } else if (i4 == 3) {
                        Layout layout8 = constraint.layout;
                        layout8.bottomToTop = i3;
                        layout8.bottomToBottom = -1;
                        layout8.baselineToBaseline = -1;
                    } else {
                        throw new IllegalArgumentException("right to " + sideToString(i4) + " undefined");
                    }
                    constraint.layout.bottomMargin = i5;
                    return;
                case 5:
                    if (i4 == 5) {
                        Layout layout9 = constraint.layout;
                        layout9.baselineToBaseline = i3;
                        layout9.bottomToBottom = -1;
                        layout9.bottomToTop = -1;
                        layout9.topToTop = -1;
                        layout9.topToBottom = -1;
                        return;
                    }
                    throw new IllegalArgumentException("right to " + sideToString(i4) + " undefined");
                case 6:
                    if (i4 == 6) {
                        Layout layout10 = constraint.layout;
                        layout10.startToStart = i3;
                        layout10.startToEnd = -1;
                    } else if (i4 == 7) {
                        Layout layout11 = constraint.layout;
                        layout11.startToEnd = i3;
                        layout11.startToStart = -1;
                    } else {
                        throw new IllegalArgumentException("right to " + sideToString(i4) + " undefined");
                    }
                    constraint.layout.startMargin = i5;
                    return;
                case 7:
                    if (i4 == 7) {
                        Layout layout12 = constraint.layout;
                        layout12.endToEnd = i3;
                        layout12.endToStart = -1;
                    } else if (i4 == 6) {
                        Layout layout13 = constraint.layout;
                        layout13.endToStart = i3;
                        layout13.endToEnd = -1;
                    } else {
                        throw new IllegalArgumentException("right to " + sideToString(i4) + " undefined");
                    }
                    constraint.layout.endMargin = i5;
                    return;
                default:
                    throw new IllegalArgumentException(sideToString(i2) + " to " + sideToString(i4) + " unknown");
            }
        }
    }

    public void createHorizontalChain(int i, int i2, int i3, int i4, int[] iArr, float[] fArr, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048619, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), iArr, fArr, Integer.valueOf(i5)}) == null) {
            createHorizontalChain(i, i2, i3, i4, iArr, fArr, i5, 1, 2);
        }
    }

    public void createHorizontalChainRtl(int i, int i2, int i3, int i4, int[] iArr, float[] fArr, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048620, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), iArr, fArr, Integer.valueOf(i5)}) == null) {
            createHorizontalChain(i, i2, i3, i4, iArr, fArr, i5, 6, 7);
        }
    }

    public void createVerticalChain(int i, int i2, int i3, int i4, int[] iArr, float[] fArr, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048621, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), iArr, fArr, Integer.valueOf(i5)}) == null) {
            if (iArr.length >= 2) {
                if (fArr != null && fArr.length != iArr.length) {
                    throw new IllegalArgumentException("must have 2 or more widgets in a chain");
                }
                if (fArr != null) {
                    get(iArr[0]).layout.verticalWeight = fArr[0];
                }
                get(iArr[0]).layout.verticalChainStyle = i5;
                connect(iArr[0], 3, i, i2, 0);
                for (int i6 = 1; i6 < iArr.length; i6++) {
                    int i7 = iArr[i6];
                    int i8 = i6 - 1;
                    connect(iArr[i6], 3, iArr[i8], 4, 0);
                    connect(iArr[i8], 4, iArr[i6], 3, 0);
                    if (fArr != null) {
                        get(iArr[i6]).layout.verticalWeight = fArr[i6];
                    }
                }
                connect(iArr[iArr.length - 1], 4, i3, i4, 0);
                return;
            }
            throw new IllegalArgumentException("must have 2 or more widgets in a chain");
        }
    }

    public void parseStringAttributes(Constraint constraint, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048639, this, constraint, str) == null) {
            String[] splitString = splitString(str);
            for (int i = 0; i < splitString.length; i++) {
                String[] split = splitString[i].split("=");
                Log.w(TAG, " Unable to parse " + splitString[i]);
                constraint.setStringValue(split[0], split[1]);
            }
        }
    }

    public void setElevation(int i, float f) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048652, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) && Build.VERSION.SDK_INT >= 21) {
            get(i).transform.elevation = f;
            get(i).transform.applyElevation = true;
        }
    }

    public void setGuidelinePercent(int i, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048658, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) {
            get(i).layout.guidePercent = f;
            get(i).layout.guideEnd = -1;
            get(i).layout.guideBegin = -1;
        }
    }

    public void readFallback(ConstraintSet constraintSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, constraintSet) == null) {
            for (Integer num : constraintSet.mConstraints.keySet()) {
                int intValue = num.intValue();
                Constraint constraint = constraintSet.mConstraints.get(num);
                if (!this.mConstraints.containsKey(Integer.valueOf(intValue))) {
                    this.mConstraints.put(Integer.valueOf(intValue), new Constraint());
                }
                Constraint constraint2 = this.mConstraints.get(Integer.valueOf(intValue));
                Layout layout = constraint2.layout;
                if (!layout.mApply) {
                    layout.copyFrom(constraint.layout);
                }
                PropertySet propertySet = constraint2.propertySet;
                if (!propertySet.mApply) {
                    propertySet.copyFrom(constraint.propertySet);
                }
                Transform transform = constraint2.transform;
                if (!transform.mApply) {
                    transform.copyFrom(constraint.transform);
                }
                Motion motion = constraint2.motion;
                if (!motion.mApply) {
                    motion.copyFrom(constraint.motion);
                }
                for (String str : constraint.mCustomConstraints.keySet()) {
                    if (!constraint2.mCustomConstraints.containsKey(str)) {
                        constraint2.mCustomConstraints.put(str, constraint.mCustomConstraints.get(str));
                    }
                }
            }
        }
    }

    public void removeFromHorizontalChain(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048643, this, i) == null) && this.mConstraints.containsKey(Integer.valueOf(i))) {
            Constraint constraint = this.mConstraints.get(Integer.valueOf(i));
            Layout layout = constraint.layout;
            int i2 = layout.leftToRight;
            int i3 = layout.rightToLeft;
            if (i2 == -1 && i3 == -1) {
                int i4 = layout.startToEnd;
                int i5 = layout.endToStart;
                if (i4 != -1 || i5 != -1) {
                    if (i4 != -1 && i5 != -1) {
                        connect(i4, 7, i5, 6, 0);
                        connect(i5, 6, i2, 7, 0);
                    } else if (i2 != -1 || i5 != -1) {
                        Layout layout2 = constraint.layout;
                        int i6 = layout2.rightToRight;
                        if (i6 != -1) {
                            connect(i2, 7, i6, 7, 0);
                        } else {
                            int i7 = layout2.leftToLeft;
                            if (i7 != -1) {
                                connect(i5, 6, i7, 6, 0);
                            }
                        }
                    }
                }
                clear(i, 6);
                clear(i, 7);
                return;
            }
            if (i2 != -1 && i3 != -1) {
                connect(i2, 2, i3, 1, 0);
                connect(i3, 1, i2, 2, 0);
            } else if (i2 != -1 || i3 != -1) {
                Layout layout3 = constraint.layout;
                int i8 = layout3.rightToRight;
                if (i8 != -1) {
                    connect(i2, 2, i8, 2, 0);
                } else {
                    int i9 = layout3.leftToLeft;
                    if (i9 != -1) {
                        connect(i3, 1, i9, 1, 0);
                    }
                }
            }
            clear(i, 1);
            clear(i, 2);
        }
    }

    public void setGoneMargin(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048655, this, i, i2, i3) == null) {
            Constraint constraint = get(i);
            switch (i2) {
                case 1:
                    constraint.layout.goneLeftMargin = i3;
                    return;
                case 2:
                    constraint.layout.goneRightMargin = i3;
                    return;
                case 3:
                    constraint.layout.goneTopMargin = i3;
                    return;
                case 4:
                    constraint.layout.goneBottomMargin = i3;
                    return;
                case 5:
                    throw new IllegalArgumentException("baseline does not support margins");
                case 6:
                    constraint.layout.goneStartMargin = i3;
                    return;
                case 7:
                    constraint.layout.goneEndMargin = i3;
                    return;
                default:
                    throw new IllegalArgumentException("unknown constraint");
            }
        }
    }

    public void setMargin(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048663, this, i, i2, i3) == null) {
            Constraint constraint = get(i);
            switch (i2) {
                case 1:
                    constraint.layout.leftMargin = i3;
                    return;
                case 2:
                    constraint.layout.rightMargin = i3;
                    return;
                case 3:
                    constraint.layout.topMargin = i3;
                    return;
                case 4:
                    constraint.layout.bottomMargin = i3;
                    return;
                case 5:
                    throw new IllegalArgumentException("baseline does not support margins");
                case 6:
                    constraint.layout.startMargin = i3;
                    return;
                case 7:
                    constraint.layout.endMargin = i3;
                    return;
                default:
                    throw new IllegalArgumentException("unknown constraint");
            }
        }
    }
}

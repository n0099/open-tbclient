package androidx.vectordrawable.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.core.content.res.ComplexColorCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public class VectorDrawableCompat extends VectorDrawableCommon {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DBG_VECTOR_DRAWABLE = false;
    public static final PorterDuff.Mode DEFAULT_TINT_MODE;
    public static final int LINECAP_BUTT = 0;
    public static final int LINECAP_ROUND = 1;
    public static final int LINECAP_SQUARE = 2;
    public static final int LINEJOIN_BEVEL = 2;
    public static final int LINEJOIN_MITER = 0;
    public static final int LINEJOIN_ROUND = 1;
    public static final String LOGTAG = "VectorDrawableCompat";
    public static final int MAX_CACHED_BITMAP_SIZE = 2048;
    public static final String SHAPE_CLIP_PATH = "clip-path";
    public static final String SHAPE_GROUP = "group";
    public static final String SHAPE_PATH = "path";
    public static final String SHAPE_VECTOR = "vector";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mAllowCaching;
    public Drawable.ConstantState mCachedConstantStateDelegate;
    public ColorFilter mColorFilter;
    public boolean mMutated;
    public PorterDuffColorFilter mTintFilter;
    public final Rect mTmpBounds;
    public final float[] mTmpFloats;
    public final Matrix mTmpMatrix;
    public VectorDrawableCompatState mVectorState;

    /* renamed from: androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public static class VClipPath extends VPath {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public VClipPath() {
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

        private void updateStateFromTypedArray(TypedArray typedArray, XmlPullParser xmlPullParser) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65538, this, typedArray, xmlPullParser) == null) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.mPathName = string;
                }
                String string2 = typedArray.getString(1);
                if (string2 != null) {
                    this.mNodes = PathParser.createNodesFromPathData(string2);
                }
                this.mFillRule = TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "fillType", 2, 0);
            }
        }

        public void inflate(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLLL(1048576, this, resources, attributeSet, theme, xmlPullParser) == null) && TypedArrayUtils.hasAttribute(xmlPullParser, "pathData")) {
                TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.STYLEABLE_VECTOR_DRAWABLE_CLIP_PATH);
                updateStateFromTypedArray(obtainAttributes, xmlPullParser);
                obtainAttributes.recycle();
            }
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VPath
        public boolean isClipPath() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public VClipPath(VClipPath vClipPath) {
            super(vClipPath);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vClipPath};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((VPath) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class VObject {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public VObject() {
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

        public boolean isStateful() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        public boolean onStateChanged(int[] iArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iArr)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        public /* synthetic */ VObject(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public static class VectorDrawableCompatState extends Drawable.ConstantState {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean mAutoMirrored;
        public boolean mCacheDirty;
        public boolean mCachedAutoMirrored;
        public Bitmap mCachedBitmap;
        public int mCachedRootAlpha;
        public int[] mCachedThemeAttrs;
        public ColorStateList mCachedTint;
        public PorterDuff.Mode mCachedTintMode;
        public int mChangingConfigurations;
        public Paint mTempPaint;
        public ColorStateList mTint;
        public PorterDuff.Mode mTintMode;
        public VPathRenderer mVPathRenderer;

        public VectorDrawableCompatState(VectorDrawableCompatState vectorDrawableCompatState) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vectorDrawableCompatState};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mTint = null;
            this.mTintMode = VectorDrawableCompat.DEFAULT_TINT_MODE;
            if (vectorDrawableCompatState != null) {
                this.mChangingConfigurations = vectorDrawableCompatState.mChangingConfigurations;
                VPathRenderer vPathRenderer = new VPathRenderer(vectorDrawableCompatState.mVPathRenderer);
                this.mVPathRenderer = vPathRenderer;
                if (vectorDrawableCompatState.mVPathRenderer.mFillPaint != null) {
                    vPathRenderer.mFillPaint = new Paint(vectorDrawableCompatState.mVPathRenderer.mFillPaint);
                }
                if (vectorDrawableCompatState.mVPathRenderer.mStrokePaint != null) {
                    this.mVPathRenderer.mStrokePaint = new Paint(vectorDrawableCompatState.mVPathRenderer.mStrokePaint);
                }
                this.mTint = vectorDrawableCompatState.mTint;
                this.mTintMode = vectorDrawableCompatState.mTintMode;
                this.mAutoMirrored = vectorDrawableCompatState.mAutoMirrored;
            }
        }

        public boolean canReuseBitmap(int i, int i2) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i, i2)) == null) ? i == this.mCachedBitmap.getWidth() && i2 == this.mCachedBitmap.getHeight() : invokeII.booleanValue;
        }

        public boolean canReuseCache() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? !this.mCacheDirty && this.mCachedTint == this.mTint && this.mCachedTintMode == this.mTintMode && this.mCachedAutoMirrored == this.mAutoMirrored && this.mCachedRootAlpha == this.mVPathRenderer.getRootAlpha() : invokeV.booleanValue;
        }

        public void createCachedBitmapIfNeeded(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
                if (this.mCachedBitmap == null || !canReuseBitmap(i, i2)) {
                    this.mCachedBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                    this.mCacheDirty = true;
                }
            }
        }

        public void drawCachedBitmapWithRootAlpha(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, canvas, colorFilter, rect) == null) {
                canvas.drawBitmap(this.mCachedBitmap, (Rect) null, rect, getPaint(colorFilter));
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mChangingConfigurations : invokeV.intValue;
        }

        public Paint getPaint(ColorFilter colorFilter) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, colorFilter)) == null) {
                if (hasTranslucentRoot() || colorFilter != null) {
                    if (this.mTempPaint == null) {
                        Paint paint = new Paint();
                        this.mTempPaint = paint;
                        paint.setFilterBitmap(true);
                    }
                    this.mTempPaint.setAlpha(this.mVPathRenderer.getRootAlpha());
                    this.mTempPaint.setColorFilter(colorFilter);
                    return this.mTempPaint;
                }
                return null;
            }
            return (Paint) invokeL.objValue;
        }

        public boolean hasTranslucentRoot() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mVPathRenderer.getRootAlpha() < 255 : invokeV.booleanValue;
        }

        public boolean isStateful() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mVPathRenderer.isStateful() : invokeV.booleanValue;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? new VectorDrawableCompat(this) : (Drawable) invokeV.objValue;
        }

        public boolean onStateChanged(int[] iArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, iArr)) == null) {
                boolean onStateChanged = this.mVPathRenderer.onStateChanged(iArr);
                this.mCacheDirty |= onStateChanged;
                return onStateChanged;
            }
            return invokeL.booleanValue;
        }

        public void updateCacheStates() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
                this.mCachedTint = this.mTint;
                this.mCachedTintMode = this.mTintMode;
                this.mCachedRootAlpha = this.mVPathRenderer.getRootAlpha();
                this.mCachedAutoMirrored = this.mAutoMirrored;
                this.mCacheDirty = false;
            }
        }

        public void updateCachedBitmap(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048588, this, i, i2) == null) {
                this.mCachedBitmap.eraseColor(0);
                this.mVPathRenderer.draw(new Canvas(this.mCachedBitmap), i, i2, null);
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable(Resources resources) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, resources)) == null) ? new VectorDrawableCompat(this) : (Drawable) invokeL.objValue;
        }

        public VectorDrawableCompatState() {
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
            this.mTint = null;
            this.mTintMode = VectorDrawableCompat.DEFAULT_TINT_MODE;
            this.mVPathRenderer = new VPathRenderer();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(585184727, "Landroidx/vectordrawable/graphics/drawable/VectorDrawableCompat;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(585184727, "Landroidx/vectordrawable/graphics/drawable/VectorDrawableCompat;");
                return;
            }
        }
        DEFAULT_TINT_MODE = PorterDuff.Mode.SRC_IN;
    }

    public VectorDrawableCompat() {
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
        this.mAllowCaching = true;
        this.mTmpFloats = new float[9];
        this.mTmpMatrix = new Matrix();
        this.mTmpBounds = new Rect();
        this.mVectorState = new VectorDrawableCompatState();
    }

    public static int applyAlpha(int i, float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i), Float.valueOf(f)})) == null) ? (i & 16777215) | (((int) (Color.alpha(i) * f)) << 24) : invokeCommon.intValue;
    }

    @Nullable
    public static VectorDrawableCompat create(@NonNull Resources resources, @DrawableRes int i, @Nullable Resources.Theme theme) {
        InterceptResult invokeLIL;
        int next;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(InputDeviceCompat.SOURCE_TRACKBALL, null, resources, i, theme)) == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
                vectorDrawableCompat.mDelegateDrawable = ResourcesCompat.getDrawable(resources, i, theme);
                vectorDrawableCompat.mCachedConstantStateDelegate = new VectorDrawableDelegateState(vectorDrawableCompat.mDelegateDrawable.getConstantState());
                return vectorDrawableCompat;
            }
            try {
                XmlResourceParser xml = resources.getXml(i);
                AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                while (true) {
                    next = xml.next();
                    if (next == 2 || next == 1) {
                        break;
                    }
                }
                if (next == 2) {
                    return createFromXmlInner(resources, (XmlPullParser) xml, asAttributeSet, theme);
                }
                throw new XmlPullParserException("No start tag found");
            } catch (IOException e) {
                Log.e(LOGTAG, "parser error", e);
                return null;
            } catch (XmlPullParserException e2) {
                Log.e(LOGTAG, "parser error", e2);
                return null;
            }
        }
        return (VectorDrawableCompat) invokeLIL.objValue;
    }

    public static VectorDrawableCompat createFromXmlInner(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65541, null, resources, xmlPullParser, attributeSet, theme)) == null) {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.inflate(resources, xmlPullParser, attributeSet, theme);
            return vectorDrawableCompat;
        }
        return (VectorDrawableCompat) invokeLLLL.objValue;
    }

    private void inflateInternal(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65542, this, resources, xmlPullParser, attributeSet, theme) == null) {
            VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
            VPathRenderer vPathRenderer = vectorDrawableCompatState.mVPathRenderer;
            ArrayDeque arrayDeque = new ArrayDeque();
            arrayDeque.push(vPathRenderer.mRootGroup);
            int eventType = xmlPullParser.getEventType();
            int depth = xmlPullParser.getDepth() + 1;
            boolean z = true;
            while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
                if (eventType == 2) {
                    String name = xmlPullParser.getName();
                    VGroup vGroup = (VGroup) arrayDeque.peek();
                    if ("path".equals(name)) {
                        VFullPath vFullPath = new VFullPath();
                        vFullPath.inflate(resources, attributeSet, theme, xmlPullParser);
                        vGroup.mChildren.add(vFullPath);
                        if (vFullPath.getPathName() != null) {
                            vPathRenderer.mVGTargetsMap.put(vFullPath.getPathName(), vFullPath);
                        }
                        z = false;
                        vectorDrawableCompatState.mChangingConfigurations = vFullPath.mChangingConfigurations | vectorDrawableCompatState.mChangingConfigurations;
                    } else if (SHAPE_CLIP_PATH.equals(name)) {
                        VClipPath vClipPath = new VClipPath();
                        vClipPath.inflate(resources, attributeSet, theme, xmlPullParser);
                        vGroup.mChildren.add(vClipPath);
                        if (vClipPath.getPathName() != null) {
                            vPathRenderer.mVGTargetsMap.put(vClipPath.getPathName(), vClipPath);
                        }
                        vectorDrawableCompatState.mChangingConfigurations = vClipPath.mChangingConfigurations | vectorDrawableCompatState.mChangingConfigurations;
                    } else if ("group".equals(name)) {
                        VGroup vGroup2 = new VGroup();
                        vGroup2.inflate(resources, attributeSet, theme, xmlPullParser);
                        vGroup.mChildren.add(vGroup2);
                        arrayDeque.push(vGroup2);
                        if (vGroup2.getGroupName() != null) {
                            vPathRenderer.mVGTargetsMap.put(vGroup2.getGroupName(), vGroup2);
                        }
                        vectorDrawableCompatState.mChangingConfigurations = vGroup2.mChangingConfigurations | vectorDrawableCompatState.mChangingConfigurations;
                    }
                } else if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                    arrayDeque.pop();
                }
                eventType = xmlPullParser.next();
            }
            if (z) {
                throw new XmlPullParserException("no path defined");
            }
        }
    }

    private boolean needMirroring() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) ? Build.VERSION.SDK_INT >= 17 && isAutoMirrored() && DrawableCompat.getLayoutDirection(this) == 1 : invokeV.booleanValue;
    }

    public static PorterDuff.Mode parseTintModeCompat(int i, PorterDuff.Mode mode) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65544, null, i, mode)) == null) {
            if (i != 3) {
                if (i != 5) {
                    if (i != 9) {
                        switch (i) {
                            case 14:
                                return PorterDuff.Mode.MULTIPLY;
                            case 15:
                                return PorterDuff.Mode.SCREEN;
                            case 16:
                                return PorterDuff.Mode.ADD;
                            default:
                                return mode;
                        }
                    }
                    return PorterDuff.Mode.SRC_ATOP;
                }
                return PorterDuff.Mode.SRC_IN;
            }
            return PorterDuff.Mode.SRC_OVER;
        }
        return (PorterDuff.Mode) invokeIL.objValue;
    }

    private void printGroupTree(VGroup vGroup, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65545, this, vGroup, i) == null) {
            String str = "";
            for (int i2 = 0; i2 < i; i2++) {
                str = str + "    ";
            }
            Log.v(LOGTAG, str + "current group is :" + vGroup.getGroupName() + " rotation is " + vGroup.mRotate);
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("matrix is :");
            sb.append(vGroup.getLocalMatrix().toString());
            Log.v(LOGTAG, sb.toString());
            for (int i3 = 0; i3 < vGroup.mChildren.size(); i3++) {
                VObject vObject = vGroup.mChildren.get(i3);
                if (vObject instanceof VGroup) {
                    printGroupTree((VGroup) vObject, i + 1);
                } else {
                    ((VPath) vObject).printVPath(i + 1);
                }
            }
        }
    }

    private void updateStateFromTypedArray(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) throws XmlPullParserException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, this, typedArray, xmlPullParser, theme) == null) {
            VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
            VPathRenderer vPathRenderer = vectorDrawableCompatState.mVPathRenderer;
            vectorDrawableCompatState.mTintMode = parseTintModeCompat(TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
            ColorStateList namedColorStateList = TypedArrayUtils.getNamedColorStateList(typedArray, xmlPullParser, theme, "tint", 1);
            if (namedColorStateList != null) {
                vectorDrawableCompatState.mTint = namedColorStateList;
            }
            vectorDrawableCompatState.mAutoMirrored = TypedArrayUtils.getNamedBoolean(typedArray, xmlPullParser, "autoMirrored", 5, vectorDrawableCompatState.mAutoMirrored);
            vPathRenderer.mViewportWidth = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "viewportWidth", 7, vPathRenderer.mViewportWidth);
            float namedFloat = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "viewportHeight", 8, vPathRenderer.mViewportHeight);
            vPathRenderer.mViewportHeight = namedFloat;
            if (vPathRenderer.mViewportWidth <= 0.0f) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
            } else if (namedFloat > 0.0f) {
                vPathRenderer.mBaseWidth = typedArray.getDimension(3, vPathRenderer.mBaseWidth);
                float dimension = typedArray.getDimension(2, vPathRenderer.mBaseHeight);
                vPathRenderer.mBaseHeight = dimension;
                if (vPathRenderer.mBaseWidth <= 0.0f) {
                    throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
                } else if (dimension > 0.0f) {
                    vPathRenderer.setAlpha(TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "alpha", 4, vPathRenderer.getAlpha()));
                    String string = typedArray.getString(0);
                    if (string != null) {
                        vPathRenderer.mRootName = string;
                        vPathRenderer.mVGTargetsMap.put(string, vPathRenderer);
                    }
                } else {
                    throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
                }
            } else {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
            }
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Drawable drawable = this.mDelegateDrawable;
            if (drawable != null) {
                DrawableCompat.canApplyTheme(drawable);
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            Drawable drawable = this.mDelegateDrawable;
            if (drawable != null) {
                drawable.draw(canvas);
                return;
            }
            copyBounds(this.mTmpBounds);
            if (this.mTmpBounds.width() <= 0 || this.mTmpBounds.height() <= 0) {
                return;
            }
            ColorFilter colorFilter = this.mColorFilter;
            if (colorFilter == null) {
                colorFilter = this.mTintFilter;
            }
            canvas.getMatrix(this.mTmpMatrix);
            this.mTmpMatrix.getValues(this.mTmpFloats);
            float abs = Math.abs(this.mTmpFloats[0]);
            float abs2 = Math.abs(this.mTmpFloats[4]);
            float abs3 = Math.abs(this.mTmpFloats[1]);
            float abs4 = Math.abs(this.mTmpFloats[3]);
            if (abs3 != 0.0f || abs4 != 0.0f) {
                abs = 1.0f;
                abs2 = 1.0f;
            }
            int min = Math.min(2048, (int) (this.mTmpBounds.width() * abs));
            int min2 = Math.min(2048, (int) (this.mTmpBounds.height() * abs2));
            if (min <= 0 || min2 <= 0) {
                return;
            }
            int save = canvas.save();
            Rect rect = this.mTmpBounds;
            canvas.translate(rect.left, rect.top);
            if (needMirroring()) {
                canvas.translate(this.mTmpBounds.width(), 0.0f);
                canvas.scale(-1.0f, 1.0f);
            }
            this.mTmpBounds.offsetTo(0, 0);
            this.mVectorState.createCachedBitmapIfNeeded(min, min2);
            if (!this.mAllowCaching) {
                this.mVectorState.updateCachedBitmap(min, min2);
            } else if (!this.mVectorState.canReuseCache()) {
                this.mVectorState.updateCachedBitmap(min, min2);
                this.mVectorState.updateCacheStates();
            }
            this.mVectorState.drawCachedBitmapWithRootAlpha(canvas, colorFilter, this.mTmpBounds);
            canvas.restoreToCount(save);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Drawable drawable = this.mDelegateDrawable;
            if (drawable != null) {
                return DrawableCompat.getAlpha(drawable);
            }
            return this.mVectorState.mVPathRenderer.getRootAlpha();
        }
        return invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Drawable drawable = this.mDelegateDrawable;
            if (drawable != null) {
                return drawable.getChangingConfigurations();
            }
            return super.getChangingConfigurations() | this.mVectorState.getChangingConfigurations();
        }
        return invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Drawable drawable = this.mDelegateDrawable;
            if (drawable != null) {
                return DrawableCompat.getColorFilter(drawable);
            }
            return this.mColorFilter;
        }
        return (ColorFilter) invokeV.objValue;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.mDelegateDrawable != null && Build.VERSION.SDK_INT >= 24) {
                return new VectorDrawableDelegateState(this.mDelegateDrawable.getConstantState());
            }
            this.mVectorState.mChangingConfigurations = getChangingConfigurations();
            return this.mVectorState;
        }
        return (Drawable.ConstantState) invokeV.objValue;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            Drawable drawable = this.mDelegateDrawable;
            if (drawable != null) {
                return drawable.getIntrinsicHeight();
            }
            return (int) this.mVectorState.mVPathRenderer.mBaseHeight;
        }
        return invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            Drawable drawable = this.mDelegateDrawable;
            if (drawable != null) {
                return drawable.getIntrinsicWidth();
            }
            return (int) this.mVectorState.mVPathRenderer.mBaseWidth;
        }
        return invokeV.intValue;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            Drawable drawable = this.mDelegateDrawable;
            if (drawable != null) {
                return drawable.getOpacity();
            }
            return -3;
        }
        return invokeV.intValue;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public float getPixelSize() {
        InterceptResult invokeV;
        VPathRenderer vPathRenderer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
            if (vectorDrawableCompatState == null || (vPathRenderer = vectorDrawableCompatState.mVPathRenderer) == null) {
                return 1.0f;
            }
            float f = vPathRenderer.mBaseWidth;
            if (f != 0.0f) {
                float f2 = vPathRenderer.mBaseHeight;
                if (f2 != 0.0f) {
                    float f3 = vPathRenderer.mViewportHeight;
                    if (f3 != 0.0f) {
                        float f4 = vPathRenderer.mViewportWidth;
                        if (f4 == 0.0f) {
                            return 1.0f;
                        }
                        return Math.min(f4 / f, f3 / f2);
                    }
                    return 1.0f;
                }
                return 1.0f;
            }
            return 1.0f;
        }
        return invokeV.floatValue;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public Object getTargetByName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) ? this.mVectorState.mVPathRenderer.mVGTargetsMap.get(str) : invokeL.objValue;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048595, this, resources, xmlPullParser, attributeSet) == null) {
            Drawable drawable = this.mDelegateDrawable;
            if (drawable != null) {
                drawable.inflate(resources, xmlPullParser, attributeSet);
            } else {
                inflate(resources, xmlPullParser, attributeSet, null);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            Drawable drawable = this.mDelegateDrawable;
            if (drawable != null) {
                drawable.invalidateSelf();
            } else {
                super.invalidateSelf();
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            Drawable drawable = this.mDelegateDrawable;
            if (drawable != null) {
                return DrawableCompat.isAutoMirrored(drawable);
            }
            return this.mVectorState.mAutoMirrored;
        }
        return invokeV.booleanValue;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        InterceptResult invokeV;
        VectorDrawableCompatState vectorDrawableCompatState;
        ColorStateList colorStateList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            Drawable drawable = this.mDelegateDrawable;
            if (drawable != null) {
                return drawable.isStateful();
            }
            return super.isStateful() || ((vectorDrawableCompatState = this.mVectorState) != null && (vectorDrawableCompatState.isStateful() || ((colorStateList = this.mVectorState.mTint) != null && colorStateList.isStateful())));
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            Drawable drawable = this.mDelegateDrawable;
            if (drawable != null) {
                drawable.mutate();
                return this;
            }
            if (!this.mMutated && super.mutate() == this) {
                this.mVectorState = new VectorDrawableCompatState(this.mVectorState);
                this.mMutated = true;
            }
            return this;
        }
        return (Drawable) invokeV.objValue;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, rect) == null) || (drawable = this.mDelegateDrawable) == null) {
            return;
        }
        drawable.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        InterceptResult invokeL;
        PorterDuff.Mode mode;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, iArr)) == null) {
            Drawable drawable = this.mDelegateDrawable;
            if (drawable != null) {
                return drawable.setState(iArr);
            }
            boolean z = false;
            VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
            ColorStateList colorStateList = vectorDrawableCompatState.mTint;
            if (colorStateList != null && (mode = vectorDrawableCompatState.mTintMode) != null) {
                this.mTintFilter = updateTintFilter(this.mTintFilter, colorStateList, mode);
                invalidateSelf();
                z = true;
            }
            if (vectorDrawableCompatState.isStateful() && vectorDrawableCompatState.onStateChanged(iArr)) {
                invalidateSelf();
                return true;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048604, this, runnable, j) == null) {
            Drawable drawable = this.mDelegateDrawable;
            if (drawable != null) {
                drawable.scheduleSelf(runnable, j);
            } else {
                super.scheduleSelf(runnable, j);
            }
        }
    }

    public void setAllowCaching(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.mAllowCaching = z;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i) == null) {
            Drawable drawable = this.mDelegateDrawable;
            if (drawable != null) {
                drawable.setAlpha(i);
            } else if (this.mVectorState.mVPathRenderer.getRootAlpha() != i) {
                this.mVectorState.mVPathRenderer.setRootAlpha(i);
                invalidateSelf();
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            Drawable drawable = this.mDelegateDrawable;
            if (drawable != null) {
                DrawableCompat.setAutoMirrored(drawable, z);
            } else {
                this.mVectorState.mAutoMirrored = z;
            }
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int i, PorterDuff.Mode mode) {
        super.setColorFilter(i, mode);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTint(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i) == null) {
            Drawable drawable = this.mDelegateDrawable;
            if (drawable != null) {
                DrawableCompat.setTint(drawable, i);
            } else {
                setTintList(ColorStateList.valueOf(i));
            }
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, colorStateList) == null) {
            Drawable drawable = this.mDelegateDrawable;
            if (drawable != null) {
                DrawableCompat.setTintList(drawable, colorStateList);
                return;
            }
            VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
            if (vectorDrawableCompatState.mTint != colorStateList) {
                vectorDrawableCompatState.mTint = colorStateList;
                this.mTintFilter = updateTintFilter(this.mTintFilter, colorStateList, vectorDrawableCompatState.mTintMode);
                invalidateSelf();
            }
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(PorterDuff.Mode mode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, mode) == null) {
            Drawable drawable = this.mDelegateDrawable;
            if (drawable != null) {
                DrawableCompat.setTintMode(drawable, mode);
                return;
            }
            VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
            if (vectorDrawableCompatState.mTintMode != mode) {
                vectorDrawableCompatState.mTintMode = mode;
                this.mTintFilter = updateTintFilter(this.mTintFilter, vectorDrawableCompatState.mTint, mode);
                invalidateSelf();
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048618, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            Drawable drawable = this.mDelegateDrawable;
            if (drawable != null) {
                return drawable.setVisible(z, z2);
            }
            return super.setVisible(z, z2);
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, runnable) == null) {
            Drawable drawable = this.mDelegateDrawable;
            if (drawable != null) {
                drawable.unscheduleSelf(runnable);
            } else {
                super.unscheduleSelf(runnable);
            }
        }
    }

    public PorterDuffColorFilter updateTintFilter(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048620, this, porterDuffColorFilter, colorStateList, mode)) == null) {
            if (colorStateList == null || mode == null) {
                return null;
            }
            return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
        }
        return (PorterDuffColorFilter) invokeLLL.objValue;
    }

    @RequiresApi(24)
    /* loaded from: classes.dex */
    public static class VectorDrawableDelegateState extends Drawable.ConstantState {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Drawable.ConstantState mDelegateState;

        public VectorDrawableDelegateState(Drawable.ConstantState constantState) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {constantState};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mDelegateState = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mDelegateState.canApplyTheme() : invokeV.booleanValue;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mDelegateState.getChangingConfigurations() : invokeV.intValue;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
                vectorDrawableCompat.mDelegateDrawable = (VectorDrawable) this.mDelegateState.newDrawable();
                return vectorDrawableCompat;
            }
            return (Drawable) invokeV.objValue;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, resources)) == null) {
                VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
                vectorDrawableCompat.mDelegateDrawable = (VectorDrawable) this.mDelegateState.newDrawable(resources);
                return vectorDrawableCompat;
            }
            return (Drawable) invokeL.objValue;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, resources, theme)) == null) {
                VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
                vectorDrawableCompat.mDelegateDrawable = (VectorDrawable) this.mDelegateState.newDrawable(resources, theme);
                return vectorDrawableCompat;
            }
            return (Drawable) invokeLL.objValue;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, colorFilter) == null) {
            Drawable drawable = this.mDelegateDrawable;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
                return;
            }
            this.mColorFilter = colorFilter;
            invalidateSelf();
        }
    }

    /* loaded from: classes.dex */
    public static abstract class VPath extends VObject {
        public static /* synthetic */ Interceptable $ic;
        public static final int FILL_TYPE_WINDING = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public int mChangingConfigurations;
        public int mFillRule;
        public PathParser.PathDataNode[] mNodes;
        public String mPathName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public VPath() {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((AnonymousClass1) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mNodes = null;
            this.mFillRule = 0;
        }

        public void applyTheme(Resources.Theme theme) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, theme) == null) {
            }
        }

        public boolean canApplyTheme() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        public PathParser.PathDataNode[] getPathData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mNodes : (PathParser.PathDataNode[]) invokeV.objValue;
        }

        public String getPathName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mPathName : (String) invokeV.objValue;
        }

        public boolean isClipPath() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        public String nodesToString(PathParser.PathDataNode[] pathDataNodeArr) {
            InterceptResult invokeL;
            float[] fArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, pathDataNodeArr)) == null) {
                String str = " ";
                for (int i = 0; i < pathDataNodeArr.length; i++) {
                    str = str + pathDataNodeArr[i].mType + ":";
                    for (int i2 = 0; i2 < pathDataNodeArr[i].mParams.length; i2++) {
                        str = str + fArr[i2] + ",";
                    }
                }
                return str;
            }
            return (String) invokeL.objValue;
        }

        public void printVPath(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
                String str = "";
                for (int i2 = 0; i2 < i; i2++) {
                    str = str + "    ";
                }
                Log.v(VectorDrawableCompat.LOGTAG, str + "current path is :" + this.mPathName + " pathData is " + nodesToString(this.mNodes));
            }
        }

        public void setPathData(PathParser.PathDataNode[] pathDataNodeArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, pathDataNodeArr) == null) {
                if (!PathParser.canMorph(this.mNodes, pathDataNodeArr)) {
                    this.mNodes = PathParser.deepCopyNodes(pathDataNodeArr);
                } else {
                    PathParser.updateNodes(this.mNodes, pathDataNodeArr);
                }
            }
        }

        public void toPath(Path path) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, path) == null) {
                path.reset();
                PathParser.PathDataNode[] pathDataNodeArr = this.mNodes;
                if (pathDataNodeArr != null) {
                    PathParser.PathDataNode.nodesToPath(pathDataNodeArr, path);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public VPath(VPath vPath) {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vPath};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((AnonymousClass1) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mNodes = null;
            this.mFillRule = 0;
            this.mPathName = vPath.mPathName;
            this.mChangingConfigurations = vPath.mChangingConfigurations;
            this.mNodes = PathParser.deepCopyNodes(vPath.mNodes);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048596, this, resources, xmlPullParser, attributeSet, theme) == null) {
            Drawable drawable = this.mDelegateDrawable;
            if (drawable != null) {
                DrawableCompat.inflate(drawable, resources, xmlPullParser, attributeSet, theme);
                return;
            }
            VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
            vectorDrawableCompatState.mVPathRenderer = new VPathRenderer();
            TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.STYLEABLE_VECTOR_DRAWABLE_TYPE_ARRAY);
            updateStateFromTypedArray(obtainAttributes, xmlPullParser, theme);
            obtainAttributes.recycle();
            vectorDrawableCompatState.mChangingConfigurations = getChangingConfigurations();
            vectorDrawableCompatState.mCacheDirty = true;
            inflateInternal(resources, xmlPullParser, attributeSet, theme);
            this.mTintFilter = updateTintFilter(this.mTintFilter, vectorDrawableCompatState.mTint, vectorDrawableCompatState.mTintMode);
        }
    }

    public VectorDrawableCompat(@NonNull VectorDrawableCompatState vectorDrawableCompatState) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vectorDrawableCompatState};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mAllowCaching = true;
        this.mTmpFloats = new float[9];
        this.mTmpMatrix = new Matrix();
        this.mTmpBounds = new Rect();
        this.mVectorState = vectorDrawableCompatState;
        this.mTintFilter = updateTintFilter(this.mTintFilter, vectorDrawableCompatState.mTint, vectorDrawableCompatState.mTintMode);
    }

    /* loaded from: classes.dex */
    public static class VFullPath extends VPath {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float mFillAlpha;
        public ComplexColorCompat mFillColor;
        public float mStrokeAlpha;
        public ComplexColorCompat mStrokeColor;
        public Paint.Cap mStrokeLineCap;
        public Paint.Join mStrokeLineJoin;
        public float mStrokeMiterlimit;
        public float mStrokeWidth;
        public int[] mThemeAttrs;
        public float mTrimPathEnd;
        public float mTrimPathOffset;
        public float mTrimPathStart;

        public VFullPath() {
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
            this.mStrokeWidth = 0.0f;
            this.mStrokeAlpha = 1.0f;
            this.mFillAlpha = 1.0f;
            this.mTrimPathStart = 0.0f;
            this.mTrimPathEnd = 1.0f;
            this.mTrimPathOffset = 0.0f;
            this.mStrokeLineCap = Paint.Cap.BUTT;
            this.mStrokeLineJoin = Paint.Join.MITER;
            this.mStrokeMiterlimit = 4.0f;
        }

        private Paint.Cap getStrokeLineCap(int i, Paint.Cap cap) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(65538, this, i, cap)) == null) {
                if (i != 0) {
                    if (i != 1) {
                        return i != 2 ? cap : Paint.Cap.SQUARE;
                    }
                    return Paint.Cap.ROUND;
                }
                return Paint.Cap.BUTT;
            }
            return (Paint.Cap) invokeIL.objValue;
        }

        private Paint.Join getStrokeLineJoin(int i, Paint.Join join) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(65539, this, i, join)) == null) {
                if (i != 0) {
                    if (i != 1) {
                        return i != 2 ? join : Paint.Join.BEVEL;
                    }
                    return Paint.Join.ROUND;
                }
                return Paint.Join.MITER;
            }
            return (Paint.Join) invokeIL.objValue;
        }

        private void updateStateFromTypedArray(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, this, typedArray, xmlPullParser, theme) == null) {
                this.mThemeAttrs = null;
                if (TypedArrayUtils.hasAttribute(xmlPullParser, "pathData")) {
                    String string = typedArray.getString(0);
                    if (string != null) {
                        this.mPathName = string;
                    }
                    String string2 = typedArray.getString(2);
                    if (string2 != null) {
                        this.mNodes = PathParser.createNodesFromPathData(string2);
                    }
                    this.mFillColor = TypedArrayUtils.getNamedComplexColor(typedArray, xmlPullParser, theme, "fillColor", 1, 0);
                    this.mFillAlpha = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "fillAlpha", 12, this.mFillAlpha);
                    this.mStrokeLineCap = getStrokeLineCap(TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.mStrokeLineCap);
                    this.mStrokeLineJoin = getStrokeLineJoin(TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.mStrokeLineJoin);
                    this.mStrokeMiterlimit = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.mStrokeMiterlimit);
                    this.mStrokeColor = TypedArrayUtils.getNamedComplexColor(typedArray, xmlPullParser, theme, "strokeColor", 3, 0);
                    this.mStrokeAlpha = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "strokeAlpha", 11, this.mStrokeAlpha);
                    this.mStrokeWidth = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "strokeWidth", 4, this.mStrokeWidth);
                    this.mTrimPathEnd = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "trimPathEnd", 6, this.mTrimPathEnd);
                    this.mTrimPathOffset = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "trimPathOffset", 7, this.mTrimPathOffset);
                    this.mTrimPathStart = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "trimPathStart", 5, this.mTrimPathStart);
                    this.mFillRule = TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "fillType", 13, this.mFillRule);
                }
            }
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VPath
        public void applyTheme(Resources.Theme theme) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, theme) != null) || this.mThemeAttrs == null) {
            }
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VPath
        public boolean canApplyTheme() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mThemeAttrs != null : invokeV.booleanValue;
        }

        public float getFillAlpha() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mFillAlpha : invokeV.floatValue;
        }

        @ColorInt
        public int getFillColor() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mFillColor.getColor() : invokeV.intValue;
        }

        public float getStrokeAlpha() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mStrokeAlpha : invokeV.floatValue;
        }

        @ColorInt
        public int getStrokeColor() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mStrokeColor.getColor() : invokeV.intValue;
        }

        public float getStrokeWidth() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mStrokeWidth : invokeV.floatValue;
        }

        public float getTrimPathEnd() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mTrimPathEnd : invokeV.floatValue;
        }

        public float getTrimPathOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mTrimPathOffset : invokeV.floatValue;
        }

        public float getTrimPathStart() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mTrimPathStart : invokeV.floatValue;
        }

        public void inflate(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048586, this, resources, attributeSet, theme, xmlPullParser) == null) {
                TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.STYLEABLE_VECTOR_DRAWABLE_PATH);
                updateStateFromTypedArray(obtainAttributes, xmlPullParser, theme);
                obtainAttributes.recycle();
            }
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VObject
        public boolean isStateful() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mFillColor.isStateful() || this.mStrokeColor.isStateful() : invokeV.booleanValue;
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VObject
        public boolean onStateChanged(int[] iArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, iArr)) == null) ? this.mStrokeColor.onStateChanged(iArr) | this.mFillColor.onStateChanged(iArr) : invokeL.booleanValue;
        }

        public void setFillAlpha(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048589, this, f) == null) {
                this.mFillAlpha = f;
            }
        }

        public void setFillColor(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
                this.mFillColor.setColor(i);
            }
        }

        public void setStrokeAlpha(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048591, this, f) == null) {
                this.mStrokeAlpha = f;
            }
        }

        public void setStrokeColor(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
                this.mStrokeColor.setColor(i);
            }
        }

        public void setStrokeWidth(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048593, this, f) == null) {
                this.mStrokeWidth = f;
            }
        }

        public void setTrimPathEnd(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048594, this, f) == null) {
                this.mTrimPathEnd = f;
            }
        }

        public void setTrimPathOffset(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048595, this, f) == null) {
                this.mTrimPathOffset = f;
            }
        }

        public void setTrimPathStart(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048596, this, f) == null) {
                this.mTrimPathStart = f;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public VFullPath(VFullPath vFullPath) {
            super(vFullPath);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vFullPath};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((VPath) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mStrokeWidth = 0.0f;
            this.mStrokeAlpha = 1.0f;
            this.mFillAlpha = 1.0f;
            this.mTrimPathStart = 0.0f;
            this.mTrimPathEnd = 1.0f;
            this.mTrimPathOffset = 0.0f;
            this.mStrokeLineCap = Paint.Cap.BUTT;
            this.mStrokeLineJoin = Paint.Join.MITER;
            this.mStrokeMiterlimit = 4.0f;
            this.mThemeAttrs = vFullPath.mThemeAttrs;
            this.mStrokeColor = vFullPath.mStrokeColor;
            this.mStrokeWidth = vFullPath.mStrokeWidth;
            this.mStrokeAlpha = vFullPath.mStrokeAlpha;
            this.mFillColor = vFullPath.mFillColor;
            this.mFillRule = vFullPath.mFillRule;
            this.mFillAlpha = vFullPath.mFillAlpha;
            this.mTrimPathStart = vFullPath.mTrimPathStart;
            this.mTrimPathEnd = vFullPath.mTrimPathEnd;
            this.mTrimPathOffset = vFullPath.mTrimPathOffset;
            this.mStrokeLineCap = vFullPath.mStrokeLineCap;
            this.mStrokeLineJoin = vFullPath.mStrokeLineJoin;
            this.mStrokeMiterlimit = vFullPath.mStrokeMiterlimit;
        }
    }

    /* loaded from: classes.dex */
    public static class VPathRenderer {
        public static /* synthetic */ Interceptable $ic;
        public static final Matrix IDENTITY_MATRIX;
        public transient /* synthetic */ FieldHolder $fh;
        public float mBaseHeight;
        public float mBaseWidth;
        public int mChangingConfigurations;
        public Paint mFillPaint;
        public final Matrix mFinalPathMatrix;
        public Boolean mIsStateful;
        public final Path mPath;
        public PathMeasure mPathMeasure;
        public final Path mRenderPath;
        public int mRootAlpha;
        public final VGroup mRootGroup;
        public String mRootName;
        public Paint mStrokePaint;
        public final ArrayMap<String, Object> mVGTargetsMap;
        public float mViewportHeight;
        public float mViewportWidth;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-989626819, "Landroidx/vectordrawable/graphics/drawable/VectorDrawableCompat$VPathRenderer;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-989626819, "Landroidx/vectordrawable/graphics/drawable/VectorDrawableCompat$VPathRenderer;");
                    return;
                }
            }
            IDENTITY_MATRIX = new Matrix();
        }

        public VPathRenderer() {
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
            this.mFinalPathMatrix = new Matrix();
            this.mBaseWidth = 0.0f;
            this.mBaseHeight = 0.0f;
            this.mViewportWidth = 0.0f;
            this.mViewportHeight = 0.0f;
            this.mRootAlpha = 255;
            this.mRootName = null;
            this.mIsStateful = null;
            this.mVGTargetsMap = new ArrayMap<>();
            this.mRootGroup = new VGroup();
            this.mPath = new Path();
            this.mRenderPath = new Path();
        }

        public static float cross(float f, float f2, float f3, float f4) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) ? (f * f4) - (f2 * f3) : invokeCommon.floatValue;
        }

        private void drawGroupTree(VGroup vGroup, Matrix matrix, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{vGroup, matrix, canvas, Integer.valueOf(i), Integer.valueOf(i2), colorFilter}) == null) {
                vGroup.mStackedMatrix.set(matrix);
                vGroup.mStackedMatrix.preConcat(vGroup.mLocalMatrix);
                canvas.save();
                for (int i3 = 0; i3 < vGroup.mChildren.size(); i3++) {
                    VObject vObject = vGroup.mChildren.get(i3);
                    if (vObject instanceof VGroup) {
                        drawGroupTree((VGroup) vObject, vGroup.mStackedMatrix, canvas, i, i2, colorFilter);
                    } else if (vObject instanceof VPath) {
                        drawPath(vGroup, (VPath) vObject, canvas, i, i2, colorFilter);
                    }
                }
                canvas.restore();
            }
        }

        private void drawPath(VGroup vGroup, VPath vPath, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(65541, this, new Object[]{vGroup, vPath, canvas, Integer.valueOf(i), Integer.valueOf(i2), colorFilter}) == null) {
                float f = i / this.mViewportWidth;
                float f2 = i2 / this.mViewportHeight;
                float min = Math.min(f, f2);
                Matrix matrix = vGroup.mStackedMatrix;
                this.mFinalPathMatrix.set(matrix);
                this.mFinalPathMatrix.postScale(f, f2);
                float matrixScale = getMatrixScale(matrix);
                if (matrixScale == 0.0f) {
                    return;
                }
                vPath.toPath(this.mPath);
                Path path = this.mPath;
                this.mRenderPath.reset();
                if (vPath.isClipPath()) {
                    this.mRenderPath.setFillType(vPath.mFillRule == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                    this.mRenderPath.addPath(path, this.mFinalPathMatrix);
                    canvas.clipPath(this.mRenderPath);
                    return;
                }
                VFullPath vFullPath = (VFullPath) vPath;
                if (vFullPath.mTrimPathStart != 0.0f || vFullPath.mTrimPathEnd != 1.0f) {
                    float f3 = vFullPath.mTrimPathStart;
                    float f4 = vFullPath.mTrimPathOffset;
                    float f5 = (f3 + f4) % 1.0f;
                    float f6 = (vFullPath.mTrimPathEnd + f4) % 1.0f;
                    if (this.mPathMeasure == null) {
                        this.mPathMeasure = new PathMeasure();
                    }
                    this.mPathMeasure.setPath(this.mPath, false);
                    float length = this.mPathMeasure.getLength();
                    float f7 = f5 * length;
                    float f8 = f6 * length;
                    path.reset();
                    if (f7 > f8) {
                        this.mPathMeasure.getSegment(f7, length, path, true);
                        this.mPathMeasure.getSegment(0.0f, f8, path, true);
                    } else {
                        this.mPathMeasure.getSegment(f7, f8, path, true);
                    }
                    path.rLineTo(0.0f, 0.0f);
                }
                this.mRenderPath.addPath(path, this.mFinalPathMatrix);
                if (vFullPath.mFillColor.willDraw()) {
                    ComplexColorCompat complexColorCompat = vFullPath.mFillColor;
                    if (this.mFillPaint == null) {
                        Paint paint = new Paint(1);
                        this.mFillPaint = paint;
                        paint.setStyle(Paint.Style.FILL);
                    }
                    Paint paint2 = this.mFillPaint;
                    if (complexColorCompat.isGradient()) {
                        Shader shader = complexColorCompat.getShader();
                        shader.setLocalMatrix(this.mFinalPathMatrix);
                        paint2.setShader(shader);
                        paint2.setAlpha(Math.round(vFullPath.mFillAlpha * 255.0f));
                    } else {
                        paint2.setShader(null);
                        paint2.setAlpha(255);
                        paint2.setColor(VectorDrawableCompat.applyAlpha(complexColorCompat.getColor(), vFullPath.mFillAlpha));
                    }
                    paint2.setColorFilter(colorFilter);
                    this.mRenderPath.setFillType(vFullPath.mFillRule == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                    canvas.drawPath(this.mRenderPath, paint2);
                }
                if (vFullPath.mStrokeColor.willDraw()) {
                    ComplexColorCompat complexColorCompat2 = vFullPath.mStrokeColor;
                    if (this.mStrokePaint == null) {
                        Paint paint3 = new Paint(1);
                        this.mStrokePaint = paint3;
                        paint3.setStyle(Paint.Style.STROKE);
                    }
                    Paint paint4 = this.mStrokePaint;
                    Paint.Join join = vFullPath.mStrokeLineJoin;
                    if (join != null) {
                        paint4.setStrokeJoin(join);
                    }
                    Paint.Cap cap = vFullPath.mStrokeLineCap;
                    if (cap != null) {
                        paint4.setStrokeCap(cap);
                    }
                    paint4.setStrokeMiter(vFullPath.mStrokeMiterlimit);
                    if (complexColorCompat2.isGradient()) {
                        Shader shader2 = complexColorCompat2.getShader();
                        shader2.setLocalMatrix(this.mFinalPathMatrix);
                        paint4.setShader(shader2);
                        paint4.setAlpha(Math.round(vFullPath.mStrokeAlpha * 255.0f));
                    } else {
                        paint4.setShader(null);
                        paint4.setAlpha(255);
                        paint4.setColor(VectorDrawableCompat.applyAlpha(complexColorCompat2.getColor(), vFullPath.mStrokeAlpha));
                    }
                    paint4.setColorFilter(colorFilter);
                    paint4.setStrokeWidth(vFullPath.mStrokeWidth * min * matrixScale);
                    canvas.drawPath(this.mRenderPath, paint4);
                }
            }
        }

        private float getMatrixScale(Matrix matrix) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, matrix)) == null) {
                float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
                matrix.mapVectors(fArr);
                float cross = cross(fArr[0], fArr[1], fArr[2], fArr[3]);
                float max = Math.max((float) Math.hypot(fArr[0], fArr[1]), (float) Math.hypot(fArr[2], fArr[3]));
                if (max > 0.0f) {
                    return Math.abs(cross) / max;
                }
                return 0.0f;
            }
            return invokeL.floatValue;
        }

        public void draw(Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{canvas, Integer.valueOf(i), Integer.valueOf(i2), colorFilter}) == null) {
                drawGroupTree(this.mRootGroup, IDENTITY_MATRIX, canvas, i, i2, colorFilter);
            }
        }

        public float getAlpha() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? getRootAlpha() / 255.0f : invokeV.floatValue;
        }

        public int getRootAlpha() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mRootAlpha : invokeV.intValue;
        }

        public boolean isStateful() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (this.mIsStateful == null) {
                    this.mIsStateful = Boolean.valueOf(this.mRootGroup.isStateful());
                }
                return this.mIsStateful.booleanValue();
            }
            return invokeV.booleanValue;
        }

        public boolean onStateChanged(int[] iArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, iArr)) == null) ? this.mRootGroup.onStateChanged(iArr) : invokeL.booleanValue;
        }

        public void setAlpha(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048581, this, f) == null) {
                setRootAlpha((int) (f * 255.0f));
            }
        }

        public void setRootAlpha(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
                this.mRootAlpha = i;
            }
        }

        public VPathRenderer(VPathRenderer vPathRenderer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vPathRenderer};
                interceptable.invokeUnInit(65538, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.mFinalPathMatrix = new Matrix();
            this.mBaseWidth = 0.0f;
            this.mBaseHeight = 0.0f;
            this.mViewportWidth = 0.0f;
            this.mViewportHeight = 0.0f;
            this.mRootAlpha = 255;
            this.mRootName = null;
            this.mIsStateful = null;
            ArrayMap<String, Object> arrayMap = new ArrayMap<>();
            this.mVGTargetsMap = arrayMap;
            this.mRootGroup = new VGroup(vPathRenderer.mRootGroup, arrayMap);
            this.mPath = new Path(vPathRenderer.mPath);
            this.mRenderPath = new Path(vPathRenderer.mRenderPath);
            this.mBaseWidth = vPathRenderer.mBaseWidth;
            this.mBaseHeight = vPathRenderer.mBaseHeight;
            this.mViewportWidth = vPathRenderer.mViewportWidth;
            this.mViewportHeight = vPathRenderer.mViewportHeight;
            this.mChangingConfigurations = vPathRenderer.mChangingConfigurations;
            this.mRootAlpha = vPathRenderer.mRootAlpha;
            this.mRootName = vPathRenderer.mRootName;
            String str = vPathRenderer.mRootName;
            if (str != null) {
                this.mVGTargetsMap.put(str, this);
            }
            this.mIsStateful = vPathRenderer.mIsStateful;
        }
    }

    /* loaded from: classes.dex */
    public static class VGroup extends VObject {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int mChangingConfigurations;
        public final ArrayList<VObject> mChildren;
        public String mGroupName;
        public final Matrix mLocalMatrix;
        public float mPivotX;
        public float mPivotY;
        public float mRotate;
        public float mScaleX;
        public float mScaleY;
        public final Matrix mStackedMatrix;
        public int[] mThemeAttrs;
        public float mTranslateX;
        public float mTranslateY;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public VGroup(VGroup vGroup, ArrayMap<String, Object> arrayMap) {
            super(null);
            VPath vClipPath;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vGroup, arrayMap};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((AnonymousClass1) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mStackedMatrix = new Matrix();
            this.mChildren = new ArrayList<>();
            this.mRotate = 0.0f;
            this.mPivotX = 0.0f;
            this.mPivotY = 0.0f;
            this.mScaleX = 1.0f;
            this.mScaleY = 1.0f;
            this.mTranslateX = 0.0f;
            this.mTranslateY = 0.0f;
            this.mLocalMatrix = new Matrix();
            this.mGroupName = null;
            this.mRotate = vGroup.mRotate;
            this.mPivotX = vGroup.mPivotX;
            this.mPivotY = vGroup.mPivotY;
            this.mScaleX = vGroup.mScaleX;
            this.mScaleY = vGroup.mScaleY;
            this.mTranslateX = vGroup.mTranslateX;
            this.mTranslateY = vGroup.mTranslateY;
            this.mThemeAttrs = vGroup.mThemeAttrs;
            String str = vGroup.mGroupName;
            this.mGroupName = str;
            this.mChangingConfigurations = vGroup.mChangingConfigurations;
            if (str != null) {
                arrayMap.put(str, this);
            }
            this.mLocalMatrix.set(vGroup.mLocalMatrix);
            ArrayList<VObject> arrayList = vGroup.mChildren;
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                VObject vObject = arrayList.get(i3);
                if (vObject instanceof VGroup) {
                    this.mChildren.add(new VGroup((VGroup) vObject, arrayMap));
                } else {
                    if (vObject instanceof VFullPath) {
                        vClipPath = new VFullPath((VFullPath) vObject);
                    } else if (vObject instanceof VClipPath) {
                        vClipPath = new VClipPath((VClipPath) vObject);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.mChildren.add(vClipPath);
                    String str2 = vClipPath.mPathName;
                    if (str2 != null) {
                        arrayMap.put(str2, vClipPath);
                    }
                }
            }
        }

        private void updateLocalMatrix() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                this.mLocalMatrix.reset();
                this.mLocalMatrix.postTranslate(-this.mPivotX, -this.mPivotY);
                this.mLocalMatrix.postScale(this.mScaleX, this.mScaleY);
                this.mLocalMatrix.postRotate(this.mRotate, 0.0f, 0.0f);
                this.mLocalMatrix.postTranslate(this.mTranslateX + this.mPivotX, this.mTranslateY + this.mPivotY);
            }
        }

        private void updateStateFromTypedArray(TypedArray typedArray, XmlPullParser xmlPullParser) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65539, this, typedArray, xmlPullParser) == null) {
                this.mThemeAttrs = null;
                this.mRotate = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "rotation", 5, this.mRotate);
                this.mPivotX = typedArray.getFloat(1, this.mPivotX);
                this.mPivotY = typedArray.getFloat(2, this.mPivotY);
                this.mScaleX = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "scaleX", 3, this.mScaleX);
                this.mScaleY = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "scaleY", 4, this.mScaleY);
                this.mTranslateX = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "translateX", 6, this.mTranslateX);
                this.mTranslateY = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "translateY", 7, this.mTranslateY);
                String string = typedArray.getString(0);
                if (string != null) {
                    this.mGroupName = string;
                }
                updateLocalMatrix();
            }
        }

        public String getGroupName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mGroupName : (String) invokeV.objValue;
        }

        public Matrix getLocalMatrix() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mLocalMatrix : (Matrix) invokeV.objValue;
        }

        public float getPivotX() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mPivotX : invokeV.floatValue;
        }

        public float getPivotY() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mPivotY : invokeV.floatValue;
        }

        public float getRotation() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mRotate : invokeV.floatValue;
        }

        public float getScaleX() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mScaleX : invokeV.floatValue;
        }

        public float getScaleY() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mScaleY : invokeV.floatValue;
        }

        public float getTranslateX() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mTranslateX : invokeV.floatValue;
        }

        public float getTranslateY() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mTranslateY : invokeV.floatValue;
        }

        public void inflate(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048585, this, resources, attributeSet, theme, xmlPullParser) == null) {
                TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.STYLEABLE_VECTOR_DRAWABLE_GROUP);
                updateStateFromTypedArray(obtainAttributes, xmlPullParser);
                obtainAttributes.recycle();
            }
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VObject
        public boolean isStateful() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                for (int i = 0; i < this.mChildren.size(); i++) {
                    if (this.mChildren.get(i).isStateful()) {
                        return true;
                    }
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VObject
        public boolean onStateChanged(int[] iArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, iArr)) == null) {
                boolean z = false;
                for (int i = 0; i < this.mChildren.size(); i++) {
                    z |= this.mChildren.get(i).onStateChanged(iArr);
                }
                return z;
            }
            return invokeL.booleanValue;
        }

        public void setPivotX(float f) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeF(1048588, this, f) == null) || f == this.mPivotX) {
                return;
            }
            this.mPivotX = f;
            updateLocalMatrix();
        }

        public void setPivotY(float f) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeF(1048589, this, f) == null) || f == this.mPivotY) {
                return;
            }
            this.mPivotY = f;
            updateLocalMatrix();
        }

        public void setRotation(float f) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeF(1048590, this, f) == null) || f == this.mRotate) {
                return;
            }
            this.mRotate = f;
            updateLocalMatrix();
        }

        public void setScaleX(float f) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeF(1048591, this, f) == null) || f == this.mScaleX) {
                return;
            }
            this.mScaleX = f;
            updateLocalMatrix();
        }

        public void setScaleY(float f) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeF(1048592, this, f) == null) || f == this.mScaleY) {
                return;
            }
            this.mScaleY = f;
            updateLocalMatrix();
        }

        public void setTranslateX(float f) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeF(1048593, this, f) == null) || f == this.mTranslateX) {
                return;
            }
            this.mTranslateX = f;
            updateLocalMatrix();
        }

        public void setTranslateY(float f) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeF(1048594, this, f) == null) || f == this.mTranslateY) {
                return;
            }
            this.mTranslateY = f;
            updateLocalMatrix();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public VGroup() {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((AnonymousClass1) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mStackedMatrix = new Matrix();
            this.mChildren = new ArrayList<>();
            this.mRotate = 0.0f;
            this.mPivotX = 0.0f;
            this.mPivotY = 0.0f;
            this.mScaleX = 1.0f;
            this.mScaleY = 1.0f;
            this.mTranslateX = 0.0f;
            this.mTranslateY = 0.0f;
            this.mLocalMatrix = new Matrix();
            this.mGroupName = null;
        }
    }
}

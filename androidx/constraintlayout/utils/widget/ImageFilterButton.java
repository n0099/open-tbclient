package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.constraintlayout.widget.R;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class ImageFilterButton extends AppCompatImageButton {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float mCrossfade;
    public ImageFilterView.ImageMatrix mImageMatrix;
    public LayerDrawable mLayer;
    public Drawable[] mLayers;
    public boolean mOverlay;
    public Path mPath;
    public RectF mRect;
    public float mRound;
    public float mRoundPercent;
    public ViewOutlineProvider mViewOutlineProvider;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageFilterButton(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mImageMatrix = new ImageFilterView.ImageMatrix();
        this.mCrossfade = 0.0f;
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        this.mOverlay = true;
        init(context, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageFilterButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mImageMatrix = new ImageFilterView.ImageMatrix();
        this.mCrossfade = 0.0f;
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        this.mOverlay = true;
        init(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageFilterButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mImageMatrix = new ImageFilterView.ImageMatrix();
        this.mCrossfade = 0.0f;
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        this.mOverlay = true;
        init(context, attributeSet);
    }

    private void setOverlay(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65542, this, z) == null) {
            this.mOverlay = z;
        }
    }

    public void setBrightness(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048583, this, f) == null) {
            ImageFilterView.ImageMatrix imageMatrix = this.mImageMatrix;
            imageMatrix.mBrightness = f;
            imageMatrix.updateMatrix(this);
        }
    }

    public void setContrast(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(InputDeviceCompat.SOURCE_TOUCHPAD, this, f) == null) {
            ImageFilterView.ImageMatrix imageMatrix = this.mImageMatrix;
            imageMatrix.mContrast = f;
            imageMatrix.updateMatrix(this);
        }
    }

    public void setSaturation(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048588, this, f) == null) {
            ImageFilterView.ImageMatrix imageMatrix = this.mImageMatrix;
            imageMatrix.mSaturation = f;
            imageMatrix.updateMatrix(this);
        }
    }

    public void setWarmth(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048589, this, f) == null) {
            ImageFilterView.ImageMatrix imageMatrix = this.mImageMatrix;
            imageMatrix.mWarmth = f;
            imageMatrix.updateMatrix(this);
        }
    }

    private void init(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, this, context, attributeSet) == null) {
            setPadding(0, 0, 0, 0);
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ImageFilterView);
                int indexCount = obtainStyledAttributes.getIndexCount();
                Drawable drawable = obtainStyledAttributes.getDrawable(0);
                for (int i = 0; i < indexCount; i++) {
                    int index = obtainStyledAttributes.getIndex(i);
                    if (index == 3) {
                        this.mCrossfade = obtainStyledAttributes.getFloat(index, 0.0f);
                    } else if (index == 8) {
                        setWarmth(obtainStyledAttributes.getFloat(index, 0.0f));
                    } else if (index == 7) {
                        setSaturation(obtainStyledAttributes.getFloat(index, 0.0f));
                    } else if (index == 2) {
                        setContrast(obtainStyledAttributes.getFloat(index, 0.0f));
                    } else if (index == 5) {
                        if (Build.VERSION.SDK_INT >= 21) {
                            setRound(obtainStyledAttributes.getDimension(index, 0.0f));
                        }
                    } else if (index == 6) {
                        if (Build.VERSION.SDK_INT >= 21) {
                            setRoundPercent(obtainStyledAttributes.getFloat(index, 0.0f));
                        }
                    } else if (index == 4) {
                        setOverlay(obtainStyledAttributes.getBoolean(index, this.mOverlay));
                    }
                }
                obtainStyledAttributes.recycle();
                if (drawable != null) {
                    Drawable[] drawableArr = new Drawable[2];
                    this.mLayers = drawableArr;
                    drawableArr[0] = getDrawable();
                    this.mLayers[1] = drawable;
                    LayerDrawable layerDrawable = new LayerDrawable(this.mLayers);
                    this.mLayer = layerDrawable;
                    layerDrawable.getDrawable(1).setAlpha((int) (this.mCrossfade * 255.0f));
                    super.setImageDrawable(this.mLayer);
                }
            }
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            if (Build.VERSION.SDK_INT < 21 && this.mRound != 0.0f && this.mPath != null) {
                z = true;
                canvas.save();
                canvas.clipPath(this.mPath);
            } else {
                z = false;
            }
            super.draw(canvas);
            if (z) {
                canvas.restore();
            }
        }
    }

    public void setCrossfade(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048585, this, f) == null) {
            this.mCrossfade = f;
            if (this.mLayers != null) {
                if (!this.mOverlay) {
                    this.mLayer.getDrawable(0).setAlpha((int) ((1.0f - this.mCrossfade) * 255.0f));
                }
                this.mLayer.getDrawable(1).setAlpha((int) (this.mCrossfade * 255.0f));
                super.setImageDrawable(this.mLayer);
            }
        }
    }

    public float getContrast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mImageMatrix.mContrast;
        }
        return invokeV.floatValue;
    }

    public float getCrossfade() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mCrossfade;
        }
        return invokeV.floatValue;
    }

    public float getRound() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mRound;
        }
        return invokeV.floatValue;
    }

    public float getRoundPercent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mRoundPercent;
        }
        return invokeV.floatValue;
    }

    public float getSaturation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mImageMatrix.mSaturation;
        }
        return invokeV.floatValue;
    }

    public float getWarmth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mImageMatrix.mWarmth;
        }
        return invokeV.floatValue;
    }

    public void setRound(float f) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048586, this, f) == null) {
            if (Float.isNaN(f)) {
                this.mRound = f;
                float f2 = this.mRoundPercent;
                this.mRoundPercent = -1.0f;
                setRoundPercent(f2);
                return;
            }
            if (this.mRound != f) {
                z = true;
            } else {
                z = false;
            }
            this.mRound = f;
            if (f != 0.0f) {
                if (this.mPath == null) {
                    this.mPath = new Path();
                }
                if (this.mRect == null) {
                    this.mRect = new RectF();
                }
                if (Build.VERSION.SDK_INT >= 21) {
                    if (this.mViewOutlineProvider == null) {
                        ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider(this) { // from class: androidx.constraintlayout.utils.widget.ImageFilterButton.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ ImageFilterButton this$0;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$0 = this;
                            }

                            @Override // android.view.ViewOutlineProvider
                            public void getOutline(View view2, Outline outline) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, view2, outline) == null) {
                                    outline.setRoundRect(0, 0, this.this$0.getWidth(), this.this$0.getHeight(), this.this$0.mRound);
                                }
                            }
                        };
                        this.mViewOutlineProvider = viewOutlineProvider;
                        setOutlineProvider(viewOutlineProvider);
                    }
                    setClipToOutline(true);
                }
                this.mRect.set(0.0f, 0.0f, getWidth(), getHeight());
                this.mPath.reset();
                Path path = this.mPath;
                RectF rectF = this.mRect;
                float f3 = this.mRound;
                path.addRoundRect(rectF, f3, f3, Path.Direction.CW);
            } else if (Build.VERSION.SDK_INT >= 21) {
                setClipToOutline(false);
            }
            if (z && Build.VERSION.SDK_INT >= 21) {
                invalidateOutline();
            }
        }
    }

    public void setRoundPercent(float f) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048587, this, f) == null) {
            if (this.mRoundPercent != f) {
                z = true;
            } else {
                z = false;
            }
            this.mRoundPercent = f;
            if (f != 0.0f) {
                if (this.mPath == null) {
                    this.mPath = new Path();
                }
                if (this.mRect == null) {
                    this.mRect = new RectF();
                }
                if (Build.VERSION.SDK_INT >= 21) {
                    if (this.mViewOutlineProvider == null) {
                        ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider(this) { // from class: androidx.constraintlayout.utils.widget.ImageFilterButton.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ ImageFilterButton this$0;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$0 = this;
                            }

                            @Override // android.view.ViewOutlineProvider
                            public void getOutline(View view2, Outline outline) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, view2, outline) == null) {
                                    int width = this.this$0.getWidth();
                                    int height = this.this$0.getHeight();
                                    outline.setRoundRect(0, 0, width, height, (Math.min(width, height) * this.this$0.mRoundPercent) / 2.0f);
                                }
                            }
                        };
                        this.mViewOutlineProvider = viewOutlineProvider;
                        setOutlineProvider(viewOutlineProvider);
                    }
                    setClipToOutline(true);
                }
                int width = getWidth();
                int height = getHeight();
                float min = (Math.min(width, height) * this.mRoundPercent) / 2.0f;
                this.mRect.set(0.0f, 0.0f, width, height);
                this.mPath.reset();
                this.mPath.addRoundRect(this.mRect, min, min, Path.Direction.CW);
            } else if (Build.VERSION.SDK_INT >= 21) {
                setClipToOutline(false);
            }
            if (z && Build.VERSION.SDK_INT >= 21) {
                invalidateOutline();
            }
        }
    }
}

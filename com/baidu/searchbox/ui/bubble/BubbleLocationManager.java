package com.baidu.searchbox.ui.bubble;

import android.content.Context;
import android.view.View;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.ui.bubble.views.BubbleBaseView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class BubbleLocationManager {
    public static final boolean DEBUG = false;
    public static final String TAG = "BubbleLocation";
    public float mOffsetOfArrow;
    public boolean isShowLeftEndPoint = false;
    public float mBetweenPadding = 0.0f;
    public boolean mIsAutoDetectShowPosition = true;
    public BubblePosition mBubbleForceShowPosition = BubblePosition.INVALID;
    public boolean mD20Template = true;

    /* renamed from: com.baidu.searchbox.ui.bubble.BubbleLocationManager$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$ui$bubble$BubblePosition;

        static {
            int[] iArr = new int[BubblePosition.values().length];
            $SwitchMap$com$baidu$searchbox$ui$bubble$BubblePosition = iArr;
            try {
                iArr[BubblePosition.UP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ui$bubble$BubblePosition[BubblePosition.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ui$bubble$BubblePosition[BubblePosition.LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ui$bubble$BubblePosition[BubblePosition.RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private int getAnchorCenterDownMargin(BubbleBaseView bubbleBaseView) {
        return (bubbleBaseView.mRootView.getMeasuredHeight() - getAnchorInRoot(bubbleBaseView)[1]) - (bubbleBaseView.mAnchorView.getMeasuredHeight() / 2);
    }

    private int getAnchorCenterLeftMargin(BubbleBaseView bubbleBaseView) {
        return getAnchorInRoot(bubbleBaseView)[0] + (bubbleBaseView.mAnchorView.getMeasuredWidth() / 2);
    }

    private int getAnchorCenterUpMargin(BubbleBaseView bubbleBaseView) {
        return getAnchorInRoot(bubbleBaseView)[1] + (bubbleBaseView.mAnchorView.getMeasuredHeight() / 2);
    }

    private int[] getAnchorInRoot(BubbleBaseView bubbleBaseView) {
        int[] iArr = new int[2];
        bubbleBaseView.mAnchorView.getLocationOnScreen(iArr);
        int[] iArr2 = new int[2];
        bubbleBaseView.mRootView.getLocationOnScreen(iArr2);
        return new int[]{iArr[0] - iArr2[0], iArr[1] - iArr2[1]};
    }

    private int getBubbleRadius(Context context) {
        if (this.mD20Template) {
            return context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701f8);
        }
        return context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701f7);
    }

    public static int[] getPositions(View view2) {
        if (view2 == null) {
            return null;
        }
        int[] iArr = new int[2];
        view2.getLocationOnScreen(iArr);
        return iArr;
    }

    private boolean isDisplayableAtLeft(BubbleBaseView bubbleBaseView) {
        if (bubbleBaseView.mBubbleView.getMeasuredWidth() + DeviceUtil.ScreenInfo.dp2px(bubbleBaseView.mAnchorView.getContext(), this.mBetweenPadding) > getAnchorInRoot(bubbleBaseView)[0] || !isHorizontalArrowShowAble(bubbleBaseView)) {
            return false;
        }
        return true;
    }

    private boolean isDisplayableAtRight(BubbleBaseView bubbleBaseView) {
        if (bubbleBaseView.mBubbleView.getMeasuredWidth() + DeviceUtil.ScreenInfo.dp2px(bubbleBaseView.mAnchorView.getContext(), this.mBetweenPadding) > (bubbleBaseView.mRootView.getMeasuredWidth() - bubbleBaseView.mAnchorView.getMeasuredWidth()) - getAnchorInRoot(bubbleBaseView)[0] || !isHorizontalArrowShowAble(bubbleBaseView)) {
            return false;
        }
        return true;
    }

    private boolean isDisplayableAtUp(BubbleBaseView bubbleBaseView) {
        if (bubbleBaseView.mBubbleView.getMeasuredHeight() + DeviceUtil.ScreenInfo.dp2px(bubbleBaseView.mAnchorView.getContext(), this.mBetweenPadding) <= getAnchorInRoot(bubbleBaseView)[1] && isVerticalArrowShowAbleThreshold(bubbleBaseView)) {
            return true;
        }
        return false;
    }

    public void enableD20Template(boolean z) {
        this.mD20Template = z;
    }

    public int getAnchorCenterRightMargin(BubbleBaseView bubbleBaseView) {
        return (bubbleBaseView.mRootView.getMeasuredWidth() - getAnchorInRoot(bubbleBaseView)[0]) - (bubbleBaseView.mAnchorView.getMeasuredWidth() / 2);
    }

    public void setPaddingBetweenAnchor(float f) {
        this.mBetweenPadding = f;
    }

    private boolean isDisplayableAtDown(BubbleBaseView bubbleBaseView) {
        if (bubbleBaseView.mBubbleView.getMeasuredHeight() + DeviceUtil.ScreenInfo.dp2px(bubbleBaseView.mAnchorView.getContext(), this.mBetweenPadding) <= (bubbleBaseView.mRootView.getMeasuredHeight() - bubbleBaseView.mAnchorView.getMeasuredHeight()) - getAnchorInRoot(bubbleBaseView)[1] && isVerticalArrowShowAbleThreshold(bubbleBaseView)) {
            return true;
        }
        return false;
    }

    private boolean isHorizontalArrowShowAble(BubbleBaseView bubbleBaseView) {
        float f;
        if (this.mD20Template) {
            f = 0.0f;
        } else {
            f = 15.0f;
        }
        Context context = bubbleBaseView.mAnchorView.getContext();
        int dp2px = DeviceUtil.ScreenInfo.dp2px(context, f) + context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701f7) + (context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701ee) / 2);
        if (dp2px <= getAnchorCenterUpMargin(bubbleBaseView) && dp2px <= getAnchorCenterDownMargin(bubbleBaseView)) {
            return true;
        }
        return false;
    }

    private boolean isVerticalArrowShowAbleThreshold(BubbleBaseView bubbleBaseView) {
        float f;
        if (this.mD20Template) {
            f = 0.0f;
        } else {
            f = 15.0f;
        }
        Context context = bubbleBaseView.mAnchorView.getContext();
        int dp2px = DeviceUtil.ScreenInfo.dp2px(context, f) + (getBubbleRadius(context) / 2) + (context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701ff) / 2);
        if (dp2px <= getAnchorCenterLeftMargin(bubbleBaseView) && dp2px <= getAnchorCenterRightMargin(bubbleBaseView)) {
            return true;
        }
        return false;
    }

    public BubblePosition detectShowPosition(BubbleBaseView bubbleBaseView) {
        if (!bubbleBaseView.isViewsValidate()) {
            return BubblePosition.INVALID;
        }
        if (this.mIsAutoDetectShowPosition) {
            if (isDisplayableAtUp(bubbleBaseView)) {
                return BubblePosition.UP;
            }
            if (isDisplayableAtDown(bubbleBaseView)) {
                return BubblePosition.DOWN;
            }
            if (isDisplayableAtLeft(bubbleBaseView)) {
                return BubblePosition.LEFT;
            }
            if (isDisplayableAtRight(bubbleBaseView)) {
                return BubblePosition.RIGHT;
            }
            return BubblePosition.INVALID;
        } else if (isDisplayableAtPosition(bubbleBaseView, this.mBubbleForceShowPosition)) {
            return this.mBubbleForceShowPosition;
        } else {
            return BubblePosition.INVALID;
        }
    }

    private boolean isDisplayableAtPosition(BubbleBaseView bubbleBaseView, BubblePosition bubblePosition) {
        int i = AnonymousClass1.$SwitchMap$com$baidu$searchbox$ui$bubble$BubblePosition[bubblePosition.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return false;
                    }
                    return isDisplayableAtRight(bubbleBaseView);
                }
                return isDisplayableAtLeft(bubbleBaseView);
            }
            return isDisplayableAtDown(bubbleBaseView);
        }
        return isDisplayableAtUp(bubbleBaseView);
    }

    public static boolean isSamePos(int[] iArr, int[] iArr2) {
        if (iArr != iArr2 && iArr != null && iArr2 != null) {
            if (iArr.length != iArr2.length) {
                return false;
            }
            for (int i = 0; i < iArr.length; i++) {
                if (iArr[i] != iArr2[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public int[] adjustPosition(BubbleBaseView bubbleBaseView, int[] iArr, BubblePosition bubblePosition) {
        float f;
        if (bubbleBaseView == null) {
            return new int[]{0, 0};
        }
        if (bubblePosition == BubblePosition.INVALID) {
            return iArr;
        }
        Context context = bubbleBaseView.mRootView.getContext();
        int i = iArr[0];
        int i2 = iArr[1];
        int[] iArr2 = new int[2];
        int measuredWidth = bubbleBaseView.mBubbleView.getMeasuredWidth();
        int measuredHeight = bubbleBaseView.mBubbleView.getMeasuredHeight();
        int measuredWidth2 = bubbleBaseView.mRootView.getMeasuredWidth();
        int measuredHeight2 = bubbleBaseView.mRootView.getMeasuredHeight();
        if (this.mD20Template) {
            f = 0.0f;
        } else {
            f = 15.0f;
        }
        if (bubblePosition != BubblePosition.UP && bubblePosition != BubblePosition.DOWN) {
            if (bubblePosition == BubblePosition.LEFT || bubblePosition == BubblePosition.RIGHT) {
                int i3 = measuredHeight / 2;
                if (i3 >= i2) {
                    iArr2[1] = DeviceUtil.ScreenInfo.dp2px(context, f);
                } else if (i3 >= measuredHeight2 - i2) {
                    iArr2[1] = (measuredHeight2 - measuredHeight) - DeviceUtil.ScreenInfo.dp2px(context, f);
                } else {
                    iArr2[1] = iArr[1] - (bubbleBaseView.mBubbleView.getMeasuredHeight() / 2);
                }
                if (bubblePosition == BubblePosition.LEFT) {
                    iArr2[0] = iArr[0] - bubbleBaseView.mBubbleView.getMeasuredWidth();
                } else {
                    iArr2[0] = iArr[0];
                }
            }
        } else {
            int i4 = measuredWidth / 2;
            if (i4 >= i) {
                iArr2[0] = DeviceUtil.ScreenInfo.dp2px(context, f);
            } else if (i4 >= measuredWidth2 - i) {
                iArr2[0] = (measuredWidth2 - measuredWidth) - DeviceUtil.ScreenInfo.dp2px(context, f);
            } else {
                iArr2[0] = iArr[0] - (bubbleBaseView.mBubbleView.getMeasuredWidth() / 2);
            }
            if (bubblePosition == BubblePosition.UP) {
                iArr2[1] = iArr[1] - bubbleBaseView.mBubbleView.getMeasuredHeight();
            } else {
                iArr2[1] = iArr[1];
            }
        }
        return iArr2;
    }

    public int[] getShowPosition(BubblePosition bubblePosition, BubbleBaseView bubbleBaseView) {
        if (bubblePosition != null && bubbleBaseView != null) {
            int[] iArr = new int[2];
            bubbleBaseView.mAnchorView.getLocationOnScreen(iArr);
            int[] iArr2 = new int[2];
            bubbleBaseView.mRootView.getLocationOnScreen(iArr2);
            int[] iArr3 = new int[2];
            if (bubblePosition == BubblePosition.UP) {
                iArr3[0] = iArr[0] - iArr2[0];
                if (!this.isShowLeftEndPoint) {
                    iArr3[0] = iArr3[0] + (bubbleBaseView.mAnchorView.getMeasuredWidth() / 2);
                }
                iArr3[1] = (iArr[1] - iArr2[1]) - DeviceUtil.ScreenInfo.dp2px(bubbleBaseView.mAnchorView.getContext(), this.mBetweenPadding);
            } else if (bubblePosition == BubblePosition.DOWN) {
                iArr3[0] = iArr[0] - iArr2[0];
                if (!this.isShowLeftEndPoint) {
                    iArr3[0] = iArr3[0] + (bubbleBaseView.mAnchorView.getMeasuredWidth() / 2);
                }
                iArr3[1] = (iArr[1] - iArr2[1]) + bubbleBaseView.mAnchorView.getMeasuredHeight() + DeviceUtil.ScreenInfo.dp2px(bubbleBaseView.mAnchorView.getContext(), this.mBetweenPadding);
            } else if (bubblePosition == BubblePosition.LEFT) {
                iArr3[0] = ((iArr[0] - iArr2[0]) - (bubbleBaseView.mArrowDown.getMeasuredWidth() / 2)) - DeviceUtil.ScreenInfo.dp2px(bubbleBaseView.mAnchorView.getContext(), this.mBetweenPadding);
                iArr3[1] = (iArr[1] - iArr2[1]) + (bubbleBaseView.mAnchorView.getMeasuredHeight() / 2);
            } else if (bubblePosition == BubblePosition.RIGHT) {
                iArr3[0] = (iArr[0] - iArr2[0]) + bubbleBaseView.mAnchorView.getMeasuredWidth() + DeviceUtil.ScreenInfo.dp2px(bubbleBaseView.mAnchorView.getContext(), this.mBetweenPadding);
                iArr3[1] = (iArr[1] - iArr2[1]) + (bubbleBaseView.mAnchorView.getMeasuredHeight() / 2);
            }
            int[] adjustPosition = adjustPosition(bubbleBaseView, iArr3, bubblePosition);
            if (bubblePosition != BubblePosition.UP && bubblePosition != BubblePosition.DOWN) {
                if (bubblePosition == BubblePosition.LEFT || bubblePosition == BubblePosition.RIGHT) {
                    bubbleBaseView.mBubbleArrow.setY(((iArr3[1] - adjustPosition[1]) - Math.max(bubbleBaseView.mArrowLeft.getMeasuredHeight() / 2, bubbleBaseView.mArrowRight.getMeasuredHeight() / 2)) + this.mOffsetOfArrow);
                }
            } else {
                bubbleBaseView.mBubbleArrow.setX(((iArr3[0] - adjustPosition[0]) - Math.max(bubbleBaseView.mArrowDown.getMeasuredWidth() / 2, bubbleBaseView.mArrowUp.getMeasuredWidth() / 2)) + this.mOffsetOfArrow);
            }
            return adjustPosition;
        }
        return new int[]{0, 0};
    }
}

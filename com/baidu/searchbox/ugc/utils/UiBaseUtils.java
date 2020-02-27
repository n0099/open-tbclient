package com.baidu.searchbox.ugc.utils;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.util.List;
/* loaded from: classes13.dex */
public class UiBaseUtils {
    private static Context context = AppRuntime.getAppContext();

    public static void setViewColor(View view, int i) {
        if (view != null) {
            view.setBackgroundColor(getColor(i));
        }
    }

    public static void setViewDrawable(View view, int i) {
        if (view != null) {
            view.setBackground(getDrawable(i));
        }
    }

    public static void setTextResource(TextView textView, int i) {
        if (textView != null) {
            textView.setTextColor(getColor(i));
        }
    }

    public static void setViewColorResource(View view, int i) {
        if (view != null) {
            view.setBackgroundColor(getColor(i));
        }
    }

    public static void setViewDrawableResource(View view, int i) {
        if (view != null) {
            view.setBackground(getDrawable(i));
        }
    }

    public static void setViewBackgroundDrawable(View view, Drawable drawable) {
        if (view != null) {
            view.setBackground(drawable);
        }
    }

    public static void setTextColor(TextView textView, int i) {
        if (textView != null) {
            textView.setTextColor(i);
        }
    }

    public static void setTextColorResource(TextView textView, int i) {
        if (textView != null) {
            textView.setTextColor(getColor(i));
        }
    }

    public static void setTextStringResource(TextView textView, int i) {
        if (textView != null) {
            textView.setText(getText(i));
        }
    }

    public static void setTextString(TextView textView, String str) {
        if (textView != null) {
            textView.setText(str);
        }
    }

    public static void setEditResource(EditText editText, int i) {
        if (editText != null) {
            editText.setTextColor(getColor(i));
        }
    }

    public static void setEditHintResource(EditText editText, int i) {
        if (editText != null) {
            editText.setHintTextColor(getColor(i));
        }
    }

    public static void setEditTextSelectedColor(EditText editText, int i) {
        if (editText != null) {
            editText.setHighlightColor(getColor(i));
        }
    }

    public static void setOnClickListener(View view, View.OnClickListener onClickListener) {
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    public static void setOnTouchListener(View view, View.OnTouchListener onTouchListener) {
        if (view != null) {
            view.setOnTouchListener(onTouchListener);
        }
    }

    public static ViewGroup.LayoutParams getLayoutParams(View view) {
        if (view == null) {
            return null;
        }
        return view.getLayoutParams();
    }

    public static <T extends ViewGroup.LayoutParams> void setLayoutParams(View view, T t) {
        if (view != null && t != null) {
            view.setLayoutParams(t);
        }
    }

    public static void setVisibility(View view, int i) {
        if (view != null) {
            view.setVisibility(i);
        }
    }

    public static void setCompoundDrawables(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (textView != null) {
            textView.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        }
    }

    public static void setCompoundDrawablesWithIntrinsicBounds(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (textView != null) {
            textView.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        }
    }

    public static void setCompoundDrawablePadding(TextView textView, int i) {
        if (textView != null) {
            textView.setCompoundDrawablePadding(i);
        }
    }

    public static void startAnimation(View view, Animation animation) {
        if (view != null && animation != null) {
            view.startAnimation(animation);
        }
    }

    public static void setChecked(CompoundButton compoundButton, boolean z) {
        if (compoundButton != null) {
            compoundButton.setChecked(z);
        }
    }

    public static void setOnCheckedChangeListener(CompoundButton compoundButton, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        if (compoundButton != null) {
            compoundButton.setOnCheckedChangeListener(onCheckedChangeListener);
        }
    }

    public static void setEnabled(View view, Boolean bool) {
        if (view != null) {
            view.setEnabled(bool.booleanValue());
        }
    }

    public static void setAlpha(View view, float f) {
        if (view != null) {
            view.setAlpha(f);
        }
    }

    public static void setTranslationX(View view, float f) {
        if (view != null) {
            view.setTranslationX(f);
        }
    }

    public static void setTranslationY(View view, float f) {
        if (view != null) {
            view.setTranslationY(f);
        }
    }

    public static void setClickable(View view, boolean z) {
        if (view != null) {
            view.setClickable(z);
        }
    }

    public static void runPost(View view, Runnable runnable) {
        if (view != null) {
            view.post(runnable);
        }
    }

    public static void runPostDelayed(View view, Runnable runnable, long j) {
        if (view != null) {
            view.postDelayed(runnable, j);
        }
    }

    public static void setProgressResource(SeekBar seekBar, int i) {
        if (seekBar != null) {
            seekBar.setProgressDrawable(getDrawable(i));
        }
    }

    public static void setProgressThumb(SeekBar seekBar, int i) {
        if (seekBar != null) {
            seekBar.setThumb(getDrawable(i));
        }
    }

    public static void setImageResource(ImageView imageView, int i) {
        if (imageView != null) {
            imageView.setImageDrawable(getDrawable(i));
        }
    }

    public static void setCheckBoxBtn(CheckBox checkBox, int i) {
        if (checkBox != null) {
            checkBox.setButtonDrawable(getDrawable(i));
        }
    }

    public static int getColor(int i) {
        return context.getResources().getColor(i);
    }

    public static CharSequence getText(int i) {
        return context.getResources().getText(i);
    }

    public static Drawable getDrawable(int i) {
        return context.getResources().getDrawable(i);
    }

    public static float getY(View view) {
        if (view == null) {
            return 0.0f;
        }
        return view.getY();
    }

    public static float getX(View view) {
        if (view == null) {
            return 0.0f;
        }
        return view.getX();
    }

    public static void addAnimatorListener(Animator animator, Animator.AnimatorListener animatorListener) {
        if (animator != null) {
            animator.addListener(animatorListener);
        }
    }

    public static boolean isSoftShowing(Activity activity) {
        int height = activity.getWindow().getDecorView().getHeight();
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        return height - rect.bottom != 0;
    }

    public static int getLeft(Context context2, List<ImageView> list) {
        return (list.get(2).getWidth() / 2) + DeviceUtil.ScreenInfo.dp2px(context2, 42.0f) + list.get(1).getWidth() + DeviceUtil.ScreenInfo.dp2px(context2, 42.0f) + list.get(0).getWidth() + DeviceUtil.ScreenInfo.dp2px(context2, 15.0f);
    }
}

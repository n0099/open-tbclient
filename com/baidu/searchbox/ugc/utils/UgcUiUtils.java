package com.baidu.searchbox.ugc.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.android.app.event.EventBusWrapper;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ugc.emoji.edittextrule.TopicRule;
import com.baidu.searchbox.ugc.model.AtSelectEvent;
import com.baidu.searchbox.ugc.model.TopicSelectEvent;
import com.baidu.searchbox.ugc.model.UgcTagSelectEvent;
import com.baidu.searchbox.unitedscheme.BaseRouter;
import java.util.List;
import rx.functions.b;
/* loaded from: classes12.dex */
public class UgcUiUtils {
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

    public static void setTextSelector(TextView textView, int i) {
        if (textView != null) {
            textView.setTextColor(getColorList(i));
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

    public static void setTopicHighLightColor(TopicRule topicRule, int i) {
        if (topicRule != null) {
            topicRule.setTopicHighlightColor(getColor(i));
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

    public static ColorStateList getColorList(int i) {
        return context.getResources().getColorStateList(i);
    }

    public static Drawable getDrawable(int i) {
        return context.getResources().getDrawable(i);
    }

    public static void callTopicSelectPage(Context context2, String str, b<TopicSelectEvent> bVar) {
        EventBusWrapper.registerOnMainThread(context2, TopicSelectEvent.class, bVar);
        BaseRouter.invoke(context2, str);
    }

    public static void callAtPage(Context context2, String str, b<AtSelectEvent> bVar) {
        EventBusWrapper.registerOnMainThread(context2, AtSelectEvent.class, bVar);
        BaseRouter.invoke(context2, str);
    }

    public static void callUgcTagListPage(Context context2, String str, b<UgcTagSelectEvent> bVar) {
        EventBusWrapper.registerOnMainThread(context2, UgcTagSelectEvent.class, bVar);
        BaseRouter.invoke(context2, str);
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

    public static void setTouchAlpha(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (view != null) {
                    view.setAlpha(0.2f);
                    return;
                }
                return;
            case 1:
            default:
                if (view != null) {
                    view.setAlpha(1.0f);
                    return;
                }
                return;
            case 2:
                if (view != null) {
                    view.setAlpha(0.2f);
                    return;
                }
                return;
        }
    }
}

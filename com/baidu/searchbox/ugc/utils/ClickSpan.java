package com.baidu.searchbox.ugc.utils;

import android.content.Context;
import android.content.Intent;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.baidu.pyramid.runtime.service.c;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.publisher.video.interfaces.IPublisherSboxVideoInterface;
import com.baidu.searchbox.ugc.activity.LocalPhotoPreviewActivity;
import com.baidu.searchbox.ugc.model.ImageStruct;
/* loaded from: classes12.dex */
public class ClickSpan extends ClickableSpan {
    private Context context;
    private int type;
    private String url;

    public ClickSpan(Context context, String str, int i) {
        this.url = str;
        this.type = i;
        this.context = context;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        avoidHintColor(view);
        hideInput(view);
        switch (this.type) {
            case 3:
                SelectUtil.clear();
                SelectUtil.saveSelectedImages(new ImageStruct(this.url));
                Intent intent = new Intent(this.context, LocalPhotoPreviewActivity.class);
                intent.putExtra("isSupportSingle", true);
                this.context.startActivity(intent);
                return;
            case 4:
            default:
                return;
            case 5:
                IPublisherSboxVideoInterface iPublisherSboxVideoInterface = (IPublisherSboxVideoInterface) c.a(IPublisherSboxVideoInterface.SERVICE_REFERENCE);
                if (iPublisherSboxVideoInterface != null) {
                    iPublisherSboxVideoInterface.invokePluginForAlbumResult(this.context, this.url, true);
                    return;
                }
                return;
        }
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setUnderlineText(false);
        textPaint.clearShadowLayer();
    }

    private void avoidHintColor(View view) {
        if (view instanceof TextView) {
            ((TextView) view).setHighlightColor(this.context.getResources().getColor(17170443));
        }
    }

    public void hideInput(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) AppRuntime.getAppContext().getSystemService("input_method");
        if (inputMethodManager.isActive() && view != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);
        }
    }
}

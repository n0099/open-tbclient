package com.baidu.searchbox.ugc.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.ugc.R;
import com.baidu.searchbox.ugc.model.AttachmentInfo;
import com.baidu.searchbox.ugc.utils.ResourceUtils;
import com.baidu.searchbox.ugc.utils.UgcUriUtils;
import com.baidu.searchbox.ugc.utils.UiBaseUtils;
import com.baidu.searchbox.ui.BdBaseImageView;
import com.baidu.searchbox.ui.drawable.BdPlaceHolderDrawable;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes11.dex */
public class ForwardPreview extends LinearLayout {
    public static final boolean DEBUG = AppConfig.isDebug();
    private LinearLayout mAttachmentContainer;
    private SimpleDraweeView mAttachmentItemIcon;
    private TextView mAttachmentItemName;
    private TextView mAttachmentItemTypeName;
    private TextView mForwardPreViewText;
    private SimpleDraweeView mForwardPreviewImage;
    private LinearLayout mRootLinearLayout;
    private BdBaseImageView mVideoIcon;

    public ForwardPreview(Context context) {
        this(context, null);
    }

    public ForwardPreview(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ForwardPreview(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R.layout.ugc_forward_preview_layout, (ViewGroup) this, true);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mRootLinearLayout = (LinearLayout) findViewById(ResourceUtils.getResIdByName("ugc_forward_preview_root"));
        this.mForwardPreviewImage = (SimpleDraweeView) findViewById(ResourceUtils.getResIdByName("ugc_forward_preview_img"));
        this.mVideoIcon = (BdBaseImageView) findViewById(ResourceUtils.getResIdByName("ugc_forward_preview_video_icon"));
        this.mForwardPreViewText = (TextView) findViewById(ResourceUtils.getResIdByName("ugc_forward_preview_text"));
        this.mAttachmentContainer = (LinearLayout) findViewById(ResourceUtils.getResIdByName("attachment_container"));
        this.mAttachmentItemIcon = (SimpleDraweeView) findViewById(ResourceUtils.getResIdByName("attachment_item_icon"));
        this.mAttachmentItemTypeName = (TextView) findViewById(ResourceUtils.getResIdByName("attachment_item_type_name"));
        this.mAttachmentItemName = (TextView) findViewById(ResourceUtils.getResIdByName("attachment_item_name"));
        initUI();
    }

    private void initUI() {
        this.mRootLinearLayout.setBackground(getResources().getDrawable(R.drawable.ugc_forward_container_bg));
        this.mForwardPreViewText.setTextColor(getResources().getColor(R.color.ugc_forward_preview_text_color));
        this.mForwardPreviewImage.getHierarchy().q(new BdPlaceHolderDrawable(getResources().getDrawable(R.drawable.feed_image_default_icon_cu)));
        this.mVideoIcon.setVisibility(8);
        this.mAttachmentContainer.setBackgroundColor(getResources().getColor(R.color.ugc_white));
        this.mAttachmentContainer.setVisibility(8);
        ((TextView) findViewById(R.id.attachment_item_type_name)).setTextColor(getResources().getColor(R.color.ugc_publish_no_able_color));
        ((TextView) findViewById(R.id.attachment_item_name)).setTextColor(getResources().getColor(R.color.ugc_publish_no_able_color));
        this.mAttachmentItemIcon.getHierarchy().q(new BdPlaceHolderDrawable(getResources().getDrawable(R.drawable.ugc_procedure_icon)));
    }

    public void loadImage(String str) {
        if (!TextUtils.isEmpty(str) && this.mForwardPreviewImage != null) {
            try {
                this.mForwardPreviewImage.setImageURI(UgcUriUtils.getUri(str));
            } catch (NullPointerException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void loadImage(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            loadImage(str2);
        } else if (str.equals("text")) {
            loadImage(str3);
        } else if (str.equals("imagetext")) {
            loadImage(str2);
        } else if (str.equals("video")) {
            loadImage(str2);
            UiBaseUtils.setVisibility(this.mVideoIcon, 0);
        }
    }

    public void setText(String str) {
        if (!TextUtils.isEmpty(str)) {
            UiBaseUtils.setTextString(this.mForwardPreViewText, str);
        }
    }

    public TextView getForwardPreViewText() {
        return this.mForwardPreViewText;
    }

    public void setAttachmentInfo(AttachmentInfo attachmentInfo) {
        if (attachmentInfo != null && "procedure".equals(attachmentInfo.type)) {
            UiBaseUtils.setVisibility(this.mAttachmentContainer, 0);
            if (!TextUtils.isEmpty(attachmentInfo.iconUrl) && this.mAttachmentItemIcon != null) {
                this.mAttachmentItemIcon.setImageURI(attachmentInfo.iconUrl);
            }
            UiBaseUtils.setTextString(this.mAttachmentItemTypeName, attachmentInfo.typeName);
            UiBaseUtils.setTextString(this.mAttachmentItemName, attachmentInfo.name);
            return;
        }
        UiBaseUtils.setVisibility(this.mAttachmentContainer, 8);
    }
}

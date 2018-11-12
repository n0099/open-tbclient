package com.baidu.searchbox.ng.ai.apps.view.coverview.subview;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.storage.PathType;
import com.baidu.searchbox.ng.ai.apps.storage.StorageUtil;
import com.baidu.searchbox.ng.ai.apps.view.coverview.OnActionCallback;
import com.baidu.searchbox.ng.ai.apps.view.coverview.model.CoverViewModel;
import com.baidu.searchbox.ng.ai.apps.view.coverview.model.ImageCoverViewModel;
import com.baidu.searchbox.ng.ai.apps.view.coverview.subview.CoverViewHelper;
import com.facebook.drawee.a.a.c;
import com.facebook.drawee.a.a.e;
import com.facebook.drawee.controller.b;
import com.facebook.drawee.drawable.n;
import com.facebook.drawee.view.SimpleDraweeView;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ImageCoverView extends SimpleDraweeView implements ICoverView {
    private static final boolean DEBUG = false;
    private static final String OPACITY = "opacity";
    private static final String PADDING = "padding";
    private static final String TAG = "CoverImage";
    private CoverViewHelper mCoverViewHelper;
    private CoverViewModel mModel;

    public ImageCoverView(Context context) {
        super(context);
        this.mCoverViewHelper = new CoverViewHelper();
        getHierarchy().b(n.b.icu);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.view.coverview.subview.ICoverView
    public void bindModel(@NonNull CoverViewModel coverViewModel) {
        if (coverViewModel != null) {
            this.mModel = coverViewModel;
            this.mCoverViewHelper.bindTouch(this);
            JSONObject jSONObject = coverViewModel.styleData;
            if (jSONObject != null) {
                this.mCoverViewHelper.bindBackground(this, jSONObject);
                this.mCoverViewHelper.bindBaseProperty(this, jSONObject);
                bindImageStyle(coverViewModel);
            }
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.view.coverview.subview.ICoverView
    public void setModel(@NonNull CoverViewModel coverViewModel) {
        if (coverViewModel != null) {
            this.mModel = coverViewModel;
            this.mCoverViewHelper.bindTouch(this);
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.view.coverview.subview.ICoverView
    public void setOnActionCallback(OnActionCallback onActionCallback) {
        this.mCoverViewHelper.setOnActionCallback(onActionCallback);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.view.coverview.subview.ICoverView
    public CoverViewHelper.ClickPosition getClickPosition() {
        return this.mCoverViewHelper.getClickPosition();
    }

    @Override // com.baidu.searchbox.ng.ai.apps.view.coverview.subview.ICoverView
    public CoverViewModel getModel() {
        return this.mModel;
    }

    protected void bindImageStyle(@NonNull CoverViewModel coverViewModel) {
        Uri transformUri;
        if (coverViewModel.styleData != null && (coverViewModel instanceof ImageCoverViewModel)) {
            String str = ((ImageCoverViewModel) coverViewModel).imageSource;
            if (!TextUtils.isEmpty(str) && (transformUri = transformUri(str)) != null) {
                final boolean z = ((ImageCoverViewModel) coverViewModel).loadStateSwitcher;
                e b = c.bRP().b(getController()).b(new b<com.facebook.imagepipeline.f.e>() { // from class: com.baidu.searchbox.ng.ai.apps.view.coverview.subview.ImageCoverView.1
                    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
                    public void onFailure(String str2, Throwable th) {
                        super.onFailure(str2, th);
                        if (ImageCoverView.this.mCoverViewHelper != null) {
                            OnActionCallback onActionCallback = ImageCoverView.this.mCoverViewHelper.getOnActionCallback();
                            if (z && onActionCallback != null) {
                                onActionCallback.onAction(0, ImageCoverView.this, null);
                            }
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.facebook.drawee.controller.b, com.facebook.drawee.controller.c
                    public void onFinalImageSet(String str2, com.facebook.imagepipeline.f.e eVar, Animatable animatable) {
                        super.onFinalImageSet(str2, (String) eVar, animatable);
                        if (ImageCoverView.this.mCoverViewHelper != null) {
                            OnActionCallback onActionCallback = ImageCoverView.this.mCoverViewHelper.getOnActionCallback();
                            if (z && onActionCallback != null) {
                                onActionCallback.onAction(1, ImageCoverView.this, null);
                            }
                        }
                    }
                });
                b.t(transformUri);
                setController(b.bSy());
            }
        }
    }

    private Uri transformUri(@NonNull String str) {
        String str2;
        String str3;
        PathType pathType = StorageUtil.getPathType(str);
        AiApp aiApp = AiApp.get();
        if (aiApp != null) {
            str3 = aiApp.id;
            str2 = aiApp.getVersion();
        } else {
            str2 = null;
            str3 = null;
        }
        if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str2)) {
            return null;
        }
        switch (pathType) {
            case BD_FILE:
                String scheme2Path = StorageUtil.scheme2Path(str, str3);
                if (TextUtils.isEmpty(scheme2Path)) {
                    return null;
                }
                return Uri.fromFile(new File(scheme2Path));
            case RELATIVE:
                String relativeToPath = StorageUtil.relativeToPath(str, aiApp, str2);
                if (TextUtils.isEmpty(relativeToPath)) {
                    return null;
                }
                return Uri.fromFile(new File(relativeToPath));
            case NETWORK:
                return Uri.parse(str);
            default:
                return null;
        }
    }
}

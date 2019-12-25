package com.baidu.live.tbadk.img.effect;

import android.graphics.Bitmap;
import com.baidu.live.adp.base.BdBaseApplication;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.BitmapHelper;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.imagemanager.TbImageMemoryCache;
import com.baidu.live.tbadk.plugins.MotuPlugin;
/* loaded from: classes2.dex */
public class FilterImageAction extends ImageAction {
    public static final String ACTION_NAME = "filter";
    public static final String FILTER_NAME_NORMAL = "normal";
    private String filterLabel = "";

    @Override // com.baidu.live.tbadk.img.effect.ImageAction
    public String getActionName() {
        return ACTION_NAME;
    }

    public static ImageOperation newOperation(String str) {
        ImageOperation imageOperation = new ImageOperation();
        imageOperation.actionName = ACTION_NAME;
        imageOperation.actionParam = str;
        return imageOperation;
    }

    @Override // com.baidu.live.tbadk.img.effect.ImageAction
    public void setParams(String str) {
        if (str != null) {
            this.filterLabel = str;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [108=4, 109=4] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.live.tbadk.img.effect.ImageAction
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Bitmap processImage(Bitmap bitmap, boolean z) throws Exception {
        MotuPlugin motuPlugin;
        Object newInstance;
        Bitmap bitmap2 = null;
        if (bitmap == null) {
            return null;
        }
        TbImageMemoryCache.getInstance().freePicCache(BitmapHelper.getBitmapSize(bitmap) * 2);
        if ("normal".equals(this.filterLabel)) {
            return bitmap;
        }
        try {
            newInstance = BdBaseApplication.getInst().getClassLoader().loadClass("com.baidu.tbadk.motu_gallery.MotuPluginImpl").getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable th) {
            BdLog.e(th);
        }
        if (newInstance instanceof MotuPlugin) {
            motuPlugin = (MotuPlugin) newInstance;
            if (bitmap.isMutable()) {
                Bitmap.Config config = bitmap.getConfig();
                if (config == null) {
                    config = TbConfig.BitmapConfig;
                }
                Bitmap copy = bitmap.copy(config, true);
                if (copy != null) {
                    try {
                        if (motuPlugin != null) {
                            try {
                                bitmap2 = motuPlugin.createOneKeyFilterAndApply(TbadkCoreApplication.getInst(), this.filterLabel, copy);
                            } catch (IllegalStateException e) {
                                BdLog.e(e.toString());
                                e.printStackTrace();
                                if (copy != null && copy != null) {
                                    copy.recycle();
                                }
                            } catch (Throwable th2) {
                                BdLog.e(th2.toString());
                                th2.printStackTrace();
                                if (copy != null && copy != null) {
                                    copy.recycle();
                                }
                            }
                        }
                    } catch (Throwable th3) {
                        if (copy != null && copy != null) {
                            copy.recycle();
                        }
                        throw th3;
                    }
                }
                if (copy != null && bitmap2 != copy) {
                    copy.recycle();
                }
            } else if (motuPlugin != null) {
                try {
                    bitmap2 = motuPlugin.createOneKeyFilterAndApply(TbadkCoreApplication.getInst().getApp(), this.filterLabel, bitmap);
                } catch (Throwable th4) {
                    TiebaInitialize.imgError(-1008, "motou filter failed: " + th4.toString(), "");
                    if (BdLog.isDebugMode()) {
                        th4.printStackTrace();
                    }
                }
            }
            if (bitmap2 == null) {
                if (z && bitmap2 != bitmap) {
                    bitmap.recycle();
                }
                return bitmap2;
            }
            return bitmap;
        }
        motuPlugin = null;
        if (bitmap.isMutable()) {
        }
        if (bitmap2 == null) {
        }
    }

    public String getFliterLabel() {
        return this.filterLabel;
    }

    public void setFliterLabel(String str) {
        this.filterLabel = str;
    }
}

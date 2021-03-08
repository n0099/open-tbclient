package com.baidu.live.tbadk.img.effect;

import android.graphics.Bitmap;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.img.ImageFileInfo;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes10.dex */
public class ImageActionManager {
    private static ImageActionManager _instance = new ImageActionManager();
    private final HashMap<String, Class<? extends ImageAction>> imageActions = new HashMap<>();

    public static ImageActionManager getInstance() {
        return _instance;
    }

    private ImageActionManager() {
        registerImageAction(ResizeImageAction.class);
        registerImageAction(RoundCornerImageAction.class);
        registerImageAction(FilterImageAction.class);
        registerImageAction(RotateImageAction.class);
        registerImageAction(StickerAction.class);
    }

    public Bitmap applyImageActions(Bitmap bitmap, boolean z, List<ImageOperation> list, ImageFileInfo imageFileInfo) throws Exception {
        Bitmap processImage;
        ResizeImageAction resizeImageAction;
        if (bitmap != null && !ListUtils.isEmpty(list)) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ImageAction allocateImageAction = allocateImageAction(list.get(i));
                if ((allocateImageAction instanceof StickerAction) && imageFileInfo != null) {
                    ((StickerAction) allocateImageAction).setPath(imageFileInfo.getFilePath());
                    return allocateImageAction.processImage(bitmap, z);
                }
            }
            int i2 = 0;
            ResizeImageAction resizeImageAction2 = null;
            while (i2 < size) {
                ImageOperation imageOperation = list.get(i2);
                if (ResizeImageAction.ACTION_NAME.equals(imageOperation.actionName)) {
                    resizeImageAction = (ResizeImageAction) allocateImageAction(imageOperation);
                    if (resizeImageAction2 != null) {
                        if (resizeImageAction.getMaxWidth() > resizeImageAction2.getMaxWidth() && resizeImageAction.getMaxHeight() > resizeImageAction2.getMaxHeight()) {
                            resizeImageAction = resizeImageAction2;
                        }
                    }
                    list.remove(i2);
                    i2--;
                } else {
                    resizeImageAction = resizeImageAction2;
                }
                i2++;
                resizeImageAction2 = resizeImageAction;
            }
            Bitmap processImage2 = resizeImageAction2 != null ? resizeImageAction2.processImage(bitmap, z) : null;
            if (list != null) {
                int i3 = 0;
                while (i3 < size) {
                    ImageAction allocateImageAction2 = allocateImageAction(list.get(i3));
                    if (allocateImageAction2 == null) {
                        processImage = processImage2;
                    } else if (processImage2 == null) {
                        return null;
                    } else {
                        processImage = allocateImageAction2.processImage(bitmap, z);
                    }
                    i3++;
                    processImage2 = processImage;
                }
            }
            return processImage2;
        }
        return bitmap;
    }

    public Bitmap applyImageActions(String str, List<ImageOperation> list, ImageFileInfo imageFileInfo) throws Exception {
        Bitmap bitmap;
        ResizeImageAction resizeImageAction;
        int i = 0;
        if (ListUtils.isEmpty(list)) {
            return null;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            ImageAction allocateImageAction = allocateImageAction(list.get(i2));
            if ((allocateImageAction instanceof StickerAction) && imageFileInfo != null) {
                return allocateImageAction.processImage(imageFileInfo.getFilePath());
            }
        }
        int i3 = 0;
        ResizeImageAction resizeImageAction2 = null;
        while (i3 < list.size()) {
            ImageOperation imageOperation = list.get(i3);
            if (ResizeImageAction.ACTION_NAME.equals(imageOperation.actionName)) {
                resizeImageAction = (ResizeImageAction) allocateImageAction(imageOperation);
                if (resizeImageAction2 != null) {
                    if (resizeImageAction.getMaxWidth() > resizeImageAction2.getMaxWidth() && resizeImageAction.getMaxHeight() > resizeImageAction2.getMaxHeight()) {
                        resizeImageAction = resizeImageAction2;
                    }
                }
                list.remove(i3);
                i3--;
            } else {
                resizeImageAction = resizeImageAction2;
            }
            i3++;
            resizeImageAction2 = resizeImageAction;
        }
        Bitmap processImage = resizeImageAction2 != null ? resizeImageAction2.processImage(str) : null;
        if (list != null) {
            while (true) {
                bitmap = processImage;
                if (i >= list.size()) {
                    break;
                }
                ImageAction allocateImageAction2 = allocateImageAction(list.get(i));
                if (allocateImageAction2 == null) {
                    processImage = bitmap;
                } else if (bitmap == null) {
                    processImage = allocateImageAction2.processImage(str);
                } else {
                    processImage = allocateImageAction2.processImage(bitmap, true);
                }
                i++;
            }
        } else {
            bitmap = processImage;
        }
        return bitmap;
    }

    protected ImageAction allocateImageAction(ImageOperation imageOperation) {
        ImageAction newInstance;
        Class<? extends ImageAction> cls = this.imageActions.get(imageOperation.actionName);
        if (cls != null && (newInstance = newInstance(cls)) != null) {
            newInstance.setParams(imageOperation.actionParam);
            return newInstance;
        }
        return null;
    }

    private void registerImageAction(Class<? extends ImageAction> cls) {
        ImageAction newInstance = newInstance(cls);
        if (newInstance != null) {
            this.imageActions.put(newInstance.getActionName(), cls);
        }
    }

    private ImageAction newInstance(Class<? extends ImageAction> cls) {
        try {
            return cls.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (InstantiationException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}

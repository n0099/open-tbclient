package com.baidu.live.tbadk.imagemanager;

import android.graphics.Bitmap;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.pool.BdCache;
import com.baidu.live.adp.lib.pool.BdObjectPool;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.adp.widget.imageview.BdImage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.live.tbadk.widget.largeimage.atomskeleton.BlockBitmap;
import com.baidu.live.tbadk.widget.largeimage.tools.BlockBitmapObjectFactory;
/* loaded from: classes10.dex */
public class TbImageMemoryCache {
    private static TbImageMemoryCache mInstance = new TbImageMemoryCache();
    private BdCache<String, Bitmap> mBitmap;
    private BlockBitmapObjectFactory mBlockBitmapObjectFactory;
    private BdObjectPool<BlockBitmap> mBlockBitmapSimplePool;
    private BdCache<String, BdImage> mPhoto;
    private BdCache<String, BdImage> mPic;

    public static TbImageMemoryCache getInstance() {
        return mInstance;
    }

    private TbImageMemoryCache() {
        this.mPhoto = null;
        this.mPic = null;
        this.mBitmap = null;
        this.mPhoto = new BdCache<String, BdImage>(0) { // from class: com.baidu.live.tbadk.imagemanager.TbImageMemoryCache.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.live.adp.lib.pool.BdCache
            public void entryRemoved(boolean z, String str, BdImage bdImage, BdImage bdImage2) {
                if (bdImage != null) {
                    bdImage.recycle();
                }
            }
        };
        this.mPic = new BdCache<String, BdImage>(0) { // from class: com.baidu.live.tbadk.imagemanager.TbImageMemoryCache.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.live.adp.lib.pool.BdCache
            public int sizeOf(String str, BdImage bdImage) {
                if (bdImage != null) {
                    return bdImage.size();
                }
                return 0;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.live.adp.lib.pool.BdCache
            public void entryRemoved(boolean z, String str, BdImage bdImage, BdImage bdImage2) {
                if (bdImage != null) {
                    bdImage.recycle();
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_GC_VIEW_DRAW_CACHE, str));
                }
            }
        };
        this.mBitmap = new BdCache<String, Bitmap>(0) { // from class: com.baidu.live.tbadk.imagemanager.TbImageMemoryCache.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.live.adp.lib.pool.BdCache
            public void entryRemoved(boolean z, String str, Bitmap bitmap, Bitmap bitmap2) {
                if (bitmap != null) {
                    bitmap.recycle();
                }
            }
        };
    }

    public BdObjectPool<BlockBitmap> initBlockBitmapPool(int i) {
        if (this.mBlockBitmapSimplePool != null && this.mBlockBitmapObjectFactory != null) {
            if (this.mBlockBitmapObjectFactory.getBlockSize() == i) {
                return this.mBlockBitmapSimplePool;
            }
            this.mBlockBitmapObjectFactory.setBlockSize(i);
            this.mBlockBitmapSimplePool.clear();
        }
        if (this.mBlockBitmapObjectFactory == null) {
            this.mBlockBitmapObjectFactory = new BlockBitmapObjectFactory(i);
        }
        if (this.mBlockBitmapSimplePool == null) {
            this.mBlockBitmapSimplePool = new BdObjectPool<>(this.mBlockBitmapObjectFactory, 6, 0);
        }
        return this.mBlockBitmapSimplePool;
    }

    public void releaseBlockBitmapPool() {
        if (this.mBlockBitmapSimplePool != null) {
            this.mBlockBitmapSimplePool.setMinIdle(0);
            this.mBlockBitmapSimplePool.setMaxIdle(0);
            this.mBlockBitmapSimplePool.clear();
            this.mBlockBitmapSimplePool = null;
        }
    }

    public int getPicCacheSize() {
        return this.mPic.getMaxSize();
    }

    public void initial(int i, int i2) {
        setPhotoMaxNum(i);
        setPicMaxSize(i2);
        setBitmapMaxNum(30);
    }

    public void setPhotoMaxNum(int i) {
        this.mPhoto.setMaxSize(i);
    }

    public void setPicMaxSize(int i) {
        this.mPic.setMaxSize(i);
    }

    public void setBitmapMaxNum(int i) {
        this.mBitmap.setMaxSize(i);
    }

    public void addBitmap(String str, Bitmap bitmap) {
        if (!StringUtils.isNull(str) && bitmap != null) {
            this.mBitmap.put(str, bitmap);
        }
    }

    public Bitmap getBitmap(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        return this.mBitmap.get(str);
    }

    public void deleteBitmap(String str) {
        this.mBitmap.remove(str);
    }

    public void clearBitmapList() {
        this.mBitmap.clear();
    }

    public void addPhoto(String str, BdImage bdImage) {
        addPhoto(str, bdImage, false);
    }

    public void addPhoto(String str, BdImage bdImage, boolean z) {
        if (bdImage != null && this.mPhoto != null) {
            this.mPhoto.put(str, bdImage);
        }
    }

    public boolean freePicCache(int i) {
        return this.mPic.freeMemory(i);
    }

    public void addPic(String str, BdImage bdImage, boolean z) {
        if (bdImage != null && this.mPic != null) {
            this.mPic.put(str, bdImage);
        }
    }

    public void addPic(String str, BdImage bdImage) {
        addPic(str, bdImage, false);
    }

    public void deletePhoto(String str) {
        this.mPhoto.remove(str);
    }

    public void deletePhoto(int i) {
        this.mPhoto.trimToSize(i);
    }

    public void deletePic(String str) {
        this.mPic.remove(str);
    }

    public void deletePic(int i) {
        this.mPic.trimToSize(i);
    }

    public BdImage getPhoto(String str) {
        return this.mPhoto.get(str);
    }

    public BdImage getPic(String str) {
        return this.mPic.get(str);
    }

    public boolean isGif(String str) {
        BdImage bdImage = this.mPic.get(str);
        if (bdImage != null) {
            return bdImage.isGif();
        }
        return false;
    }

    public void clearPicAndPhoto() {
        this.mPhoto.clear();
        this.mPic.clear();
    }

    public String toString() {
        return "pic:" + this.mPic.toString() + "  photo:" + this.mPhoto.toString();
    }

    public String toLogString() {
        return this.mPic.size() + "/" + this.mPic.getMaxSize() + "/" + this.mPic.evictionCount() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + this.mPhoto.size() + "/" + this.mPhoto.getMaxSize() + "/" + this.mPhoto.evictionCount();
    }
}

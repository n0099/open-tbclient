package com.baidu.live.tbadk.widget.largeimage.tools;

import com.baidu.live.adp.lib.pool.IBdPoolableObjectFactory;
import com.baidu.live.tbadk.widget.largeimage.atomskeleton.BlockBitmap;
/* loaded from: classes7.dex */
public class BlockBitmapObjectFactory implements IBdPoolableObjectFactory<BlockBitmap> {
    private int mBlockSize;

    public BlockBitmapObjectFactory(int i) {
        this.mBlockSize = i;
    }

    public int getBlockSize() {
        return this.mBlockSize;
    }

    public void setBlockSize(int i) {
        this.mBlockSize = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.live.adp.lib.pool.IBdPoolableObjectFactory
    public BlockBitmap makeObject() {
        return new BlockBitmap(this.mBlockSize);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.adp.lib.pool.IBdPoolableObjectFactory
    public void destroyObject(BlockBitmap blockBitmap) {
        if (blockBitmap != null && blockBitmap.getBitmap() != null) {
            blockBitmap.getBitmap().recycle();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.adp.lib.pool.IBdPoolableObjectFactory
    public BlockBitmap activateObject(BlockBitmap blockBitmap) {
        return blockBitmap;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.adp.lib.pool.IBdPoolableObjectFactory
    public BlockBitmap passivateObject(BlockBitmap blockBitmap) {
        return blockBitmap;
    }
}

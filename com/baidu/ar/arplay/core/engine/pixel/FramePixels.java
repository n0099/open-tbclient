package com.baidu.ar.arplay.core.engine.pixel;

import com.baidu.ar.arplay.core.engine.rotate.Orientation;
import com.baidu.ar.arplay.core.filter.ARPFilter;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public class FramePixels {
    private int mHeight;
    private Orientation mOrientation;
    private PixelType mPixelType;
    private ByteBuffer mPixelsAddress;
    private long mTimestamp;
    private int mWidth;
    private boolean mCameraFrame = false;
    private boolean mFrontCamera = false;
    private int mDegree = 90;
    private int mPixelLength = 0;

    public FramePixels(PixelType pixelType, ByteBuffer byteBuffer, int i, int i2) {
        this.mPixelType = pixelType;
        this.mWidth = i;
        this.mHeight = i2;
        this.mPixelsAddress = byteBuffer;
    }

    public int getDegree() {
        return this.mDegree;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public Orientation getOrientation() {
        return this.mOrientation;
    }

    public byte[] getPixelData() {
        byte[] bArr = new byte[this.mPixelLength];
        ARPFilter.copyNativeBytebuffer(this.mPixelsAddress, bArr, 0, this.mPixelLength);
        return bArr;
    }

    public int getPixelLength() {
        return this.mPixelLength;
    }

    public PixelType getPixelType() {
        return this.mPixelType;
    }

    public ByteBuffer getPixelsAddress() {
        return this.mPixelsAddress;
    }

    public PixelRotation getSegOrientation() {
        PixelRotation pixelRotation = PixelRotation.NoRotation;
        switch (this.mOrientation) {
            case PORTRAIT:
                return isFrontCamera() ? PixelRotation.FlipHorizontal : PixelRotation.NoRotation;
            case PORTRAIT_REVERSE:
                return isFrontCamera() ? PixelRotation.FlipVertical : PixelRotation.Rotate180;
            case LANDSCAPE:
                return isFrontCamera() ? PixelRotation.RotateRightFlipVertical : PixelRotation.RotateLeft;
            case LANDSCAPE_REVERSE:
                return isFrontCamera() ? PixelRotation.RotateRightFlipHorizontal : PixelRotation.RotateRight;
            default:
                return PixelRotation.NoRotation;
        }
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean isCameraFrame() {
        return this.mCameraFrame;
    }

    public boolean isFrontCamera() {
        return this.mFrontCamera;
    }

    public void setCameraFrame(boolean z) {
        this.mCameraFrame = z;
    }

    public void setDegree(int i) {
        this.mDegree = i;
    }

    public void setFrontCamera(boolean z) {
        this.mFrontCamera = z;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setOrientation(Orientation orientation) {
        this.mOrientation = orientation;
    }

    public void setPixelLength(int i) {
        this.mPixelLength = i;
    }

    public void setPixelType(PixelType pixelType) {
        this.mPixelType = pixelType;
    }

    public void setPixelsAddress(ByteBuffer byteBuffer) {
        this.mPixelsAddress = byteBuffer;
    }

    public void setTimestamp(long j) {
        this.mTimestamp = j;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }
}

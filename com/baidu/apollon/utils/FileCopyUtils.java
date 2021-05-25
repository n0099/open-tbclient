package com.baidu.apollon.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
/* loaded from: classes.dex */
public abstract class FileCopyUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final int f4042a = 4096;

    public static int copy(File file, File file2) throws IOException {
        Assert.notNull(file, "No input File specified");
        Assert.notNull(file2, "No output File specified");
        return copy(new BufferedInputStream(new FileInputStream(file)), new BufferedOutputStream(new FileOutputStream(file2)));
    }

    public static byte[] copyToByteArray(File file) throws IOException {
        Assert.notNull(file, "No input File specified");
        return copyToByteArray(new BufferedInputStream(new FileInputStream(file)));
    }

    public static boolean copyToFile(InputStream inputStream, File file) {
        try {
            if (file.exists()) {
                file.delete();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[4096];
            while (true) {
                int read = inputStream.read(bArr);
                if (read < 0) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            fileOutputStream.flush();
            try {
                fileOutputStream.getFD().sync();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            fileOutputStream.close();
            return true;
        } catch (IOException e3) {
            e3.printStackTrace();
            return false;
        }
    }

    public static String copyToString(Reader reader) throws IOException {
        StringWriter stringWriter = new StringWriter();
        copy(reader, stringWriter);
        return stringWriter.toString();
    }

    public static byte[] copyToByteArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(4096);
        copy(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static void copy(byte[] bArr, File file) throws IOException {
        Assert.notNull(bArr, "No input byte array specified");
        Assert.notNull(file, "No output File specified");
        copy(new ByteArrayInputStream(bArr), new BufferedOutputStream(new FileOutputStream(file)));
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE] complete} */
    public static int copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        Assert.notNull(inputStream, "No InputStream specified");
        Assert.notNull(outputStream, "No OutputStream specified");
        try {
            byte[] bArr = new byte[4096];
            int i2 = 0;
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                outputStream.write(bArr, 0, read);
                i2 += read;
            }
            outputStream.flush();
            try {
                outputStream.close();
            } catch (IOException unused) {
            }
            return i2;
        } finally {
            try {
                inputStream.close();
            } catch (IOException unused2) {
            }
            try {
                outputStream.close();
            } catch (IOException unused3) {
            }
        }
    }

    public static boolean copyToFile(String str, File file) {
        try {
            if (file.exists()) {
                file.delete();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(str.getBytes());
            fileOutputStream.flush();
            try {
                fileOutputStream.getFD().sync();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            fileOutputStream.close();
            return true;
        } catch (IOException e3) {
            e3.printStackTrace();
            return false;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE] complete} */
    public static void copy(byte[] bArr, OutputStream outputStream) throws IOException {
        Assert.notNull(bArr, "No input byte array specified");
        Assert.notNull(outputStream, "No OutputStream specified");
        try {
            outputStream.write(bArr);
        } finally {
            try {
                outputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE] complete} */
    public static int copy(Reader reader, Writer writer) throws IOException {
        Assert.notNull(reader, "No Reader specified");
        Assert.notNull(writer, "No Writer specified");
        try {
            char[] cArr = new char[4096];
            int i2 = 0;
            while (true) {
                int read = reader.read(cArr);
                if (read == -1) {
                    break;
                }
                writer.write(cArr, 0, read);
                i2 += read;
            }
            writer.flush();
            try {
                writer.close();
            } catch (IOException unused) {
            }
            return i2;
        } finally {
            try {
                reader.close();
            } catch (IOException unused2) {
            }
            try {
                writer.close();
            } catch (IOException unused3) {
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE] complete} */
    public static void copy(String str, Writer writer) throws IOException {
        Assert.notNull(str, "No input String specified");
        Assert.notNull(writer, "No Writer specified");
        try {
            writer.write(str);
        } finally {
            try {
                writer.close();
            } catch (IOException unused) {
            }
        }
    }
}

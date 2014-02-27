package com.baidu.gson.internal;

import com.baidu.gson.JsonElement;
import com.baidu.gson.JsonIOException;
import com.baidu.gson.JsonNull;
import com.baidu.gson.JsonSyntaxException;
import com.baidu.gson.internal.bind.TypeAdapters;
import com.baidu.gson.stream.JsonReader;
import com.baidu.gson.stream.JsonWriter;
import com.baidu.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;
/* loaded from: classes.dex */
public final class Streams {
    public static JsonElement parse(JsonReader jsonReader) {
        boolean z = true;
        try {
            jsonReader.peek();
            z = false;
            return TypeAdapters.JSON_ELEMENT.read(jsonReader);
        } catch (MalformedJsonException e) {
            throw new JsonSyntaxException(e);
        } catch (EOFException e2) {
            if (z) {
                return JsonNull.INSTANCE;
            }
            throw new JsonSyntaxException(e2);
        } catch (IOException e3) {
            throw new JsonIOException(e3);
        } catch (NumberFormatException e4) {
            throw new JsonSyntaxException(e4);
        }
    }

    public static void write(JsonElement jsonElement, JsonWriter jsonWriter) {
        TypeAdapters.JSON_ELEMENT.write(jsonWriter, jsonElement);
    }

    public static Writer writerForAppendable(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new AppendableWriter(appendable, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class AppendableWriter extends Writer {
        private final Appendable appendable;
        private final CurrentWrite currentWrite;

        private AppendableWriter(Appendable appendable) {
            this.currentWrite = new CurrentWrite();
            this.appendable = appendable;
        }

        /* synthetic */ AppendableWriter(Appendable appendable, AppendableWriter appendableWriter) {
            this(appendable);
        }

        @Override // java.io.Writer
        public final void write(char[] cArr, int i, int i2) {
            this.currentWrite.chars = cArr;
            this.appendable.append(this.currentWrite, i, i + i2);
        }

        @Override // java.io.Writer
        public final void write(int i) {
            this.appendable.append((char) i);
        }

        @Override // java.io.Writer, java.io.Flushable
        public final void flush() {
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
        }

        /* loaded from: classes.dex */
        class CurrentWrite implements CharSequence {
            char[] chars;

            CurrentWrite() {
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.chars.length;
            }

            @Override // java.lang.CharSequence
            public char charAt(int i) {
                return this.chars[i];
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int i, int i2) {
                return new String(this.chars, i, i2 - i);
            }
        }
    }
}
